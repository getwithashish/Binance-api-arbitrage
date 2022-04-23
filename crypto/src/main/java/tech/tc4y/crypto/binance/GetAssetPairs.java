package tech.tc4y.crypto.binance;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;

public class GetAssetPairs {
	
	private JSONObject jsonObject;
	private JSONArray jsonArray;
	private int totalSymbols;
	
	public GetAssetPairs(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
		jsonArray = (JSONArray) this.jsonObject.get("symbols");
		totalSymbols = jsonArray.size();
	}
	
	public String[] getAllAssetPairs() {
		JSONObject symbolsObject = new JSONObject();
		String[] symbolsString = new String[totalSymbols];
		for(int i=0;i<totalSymbols;i++) {
			symbolsObject = (JSONObject) jsonArray.get(i);
			symbolsString[i] = (String) symbolsObject.get("symbol");
		}
		return symbolsString;
	}
	
	public ArrayList<String> getAllTradableAssetPairs() {
		JSONObject symbolsObject = new JSONObject();
		ArrayList<String> symbolsString = new ArrayList<String>();
		for(int i=0;i<totalSymbols;i++) {
			symbolsObject = (JSONObject) jsonArray.get(i);
			if(symbolsObject.get("status").equals("TRADING")) {
				symbolsString.add((String) symbolsObject.get("symbol"));
			}
		}
		return symbolsString;
	}
	
	public ArrayList<String> getAllTradableSpotAssetPairs() {
		JSONObject symbolsObject = new JSONObject();
		ArrayList<String> symbolsStringList = new ArrayList<String>();
		for(int i=0;i<totalSymbols;i++) {
			symbolsObject = (JSONObject) jsonArray.get(i);
			if(symbolsObject.get("status").equals("TRADING")) {
				if((Boolean) symbolsObject.get("isSpotTradingAllowed") == true) {
					symbolsStringList.add((String) symbolsObject.get("symbol"));
				}
			}
		}
		return symbolsStringList;
	}
	
	public ArrayList<String> getAllTradableSpotAssetPairs(String assetSymbol) {
		ArrayList<String> baseAssetPairs = getAllSpotBaseAssetPairs(assetSymbol);
		ArrayList<String> quoteAssetPairs = getAllSpotQuoteAssetPairs(assetSymbol);
		baseAssetPairs.addAll(quoteAssetPairs);
		return baseAssetPairs;
	}
	
	public ArrayList<String> getAllSpotBaseAssetPairs(String assetBaseSymbol) {
		JSONObject symbolsObject = new JSONObject();
		ArrayList<String> symbolsStringList = new ArrayList<String>();
		for(int i=0;i<totalSymbols;i++) {
			symbolsObject = (JSONObject) jsonArray.get(i);
			if(symbolsObject.get("status").equals("TRADING")) {
				if(symbolsObject.get("baseAsset").equals(assetBaseSymbol)) {
					if((Boolean) symbolsObject.get("isSpotTradingAllowed") == true) {
						symbolsStringList.add((String) symbolsObject.get("symbol"));
					}
				}
				
			}
		}
		return symbolsStringList;
	}
	
	public ArrayList<String> getAllSpotQuoteAssetPairs(String assetQuoteSymbol) {
		JSONObject symbolsObject = new JSONObject();
		ArrayList<String> symbolsStringList = new ArrayList<String>();
		for(int i=0;i<totalSymbols;i++) {
			symbolsObject = (JSONObject) jsonArray.get(i);
			if(symbolsObject.get("status").equals("TRADING")) {
				if(symbolsObject.get("quoteAsset").equals(assetQuoteSymbol)) {
					if((Boolean) symbolsObject.get("isSpotTradingAllowed") == true) {
						symbolsStringList.add((String) symbolsObject.get("symbol"));
					}
				}
				
			}
		}
		return symbolsStringList;
	}
	
	public ArrayList<String> getAllMarginAssetPairs() {
		JSONObject symbolsObject = new JSONObject();
		ArrayList<String> symbolsStringList = new ArrayList<String>();
		for(int i=0;i<totalSymbols;i++) {
			symbolsObject = (JSONObject) jsonArray.get(i);
			if(symbolsObject.get("status").equals("TRADING")) {
				if((Boolean) symbolsObject.get("isMarginTradingAllowed") == true) {
					symbolsStringList.add((String) symbolsObject.get("symbol"));
				}
			}
		}
		return symbolsStringList;
	}

}
