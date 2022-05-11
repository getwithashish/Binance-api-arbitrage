package tech.tc4y.crypto.binance.parsers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;

public class ParseAssetPairs {
	
	private JSONObject jsonObject;
	private JSONArray jsonArray;
	private int totalPairs;
	
	public ParseAssetPairs(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
		jsonArray = (JSONArray) this.jsonObject.get("symbols");
		totalPairs = jsonArray.size();
	}
	
	public String[] getAllAssetPairs() {
		JSONObject symbolsObject = new JSONObject();
		String[] pairsString = new String[totalPairs];
		for(int i=0;i<totalPairs;i++) {
			symbolsObject = (JSONObject) jsonArray.get(i);
			pairsString[i] = (String) symbolsObject.get("symbol");
		}
		return pairsString;
	}
	
	public ArrayList<String> getAllTradableAssetPairs() {
		JSONObject symbolsObject = new JSONObject();
		ArrayList<String> pairsString = new ArrayList<String>();
		for(int i=0;i<totalPairs;i++) {
			symbolsObject = (JSONObject) jsonArray.get(i);
			if(symbolsObject.get("status").equals("TRADING")) {
				pairsString.add((String) symbolsObject.get("symbol"));
			}
		}
		return pairsString;
	}
	
	public ArrayList<String> getAllTradableSpotAssetPairs() {
		JSONObject symbolsObject = new JSONObject();
		ArrayList<String> pairsStringList = new ArrayList<String>();
		for(int i=0;i<totalPairs;i++) {
			symbolsObject = (JSONObject) jsonArray.get(i);
			if(symbolsObject.get("status").equals("TRADING")) {
				if((Boolean) symbolsObject.get("isSpotTradingAllowed") == true) {
					pairsStringList.add((String) symbolsObject.get("symbol"));
				}
			}
		}
		return pairsStringList;
	}
	
	public ArrayList<String> getAllTradableSpotAssetPairs(String assetSymbol) {
		ArrayList<String> baseAssetPairs = getAllSpotBaseAssetPairs(assetSymbol);
		ArrayList<String> quoteAssetPairs = getAllSpotQuoteAssetPairs(assetSymbol);
		baseAssetPairs.addAll(quoteAssetPairs);
		return baseAssetPairs;
	}
	
	public ArrayList<String> getAllSpotBaseAssetPairs(String assetBaseSymbol) {
		JSONObject symbolsObject = new JSONObject();
		ArrayList<String> pairsStringList = new ArrayList<String>();
		for(int i=0;i<totalPairs;i++) {
			symbolsObject = (JSONObject) jsonArray.get(i);
			if(symbolsObject.get("status").equals("TRADING")) {
				if(symbolsObject.get("baseAsset").equals(assetBaseSymbol)) {
					if((Boolean) symbolsObject.get("isSpotTradingAllowed") == true) {
						pairsStringList.add((String) symbolsObject.get("symbol"));
					}
				}
				
			}
		}
		return pairsStringList;
	}
	
	public ArrayList<String> getAllSpotQuoteAssetPairs(String assetQuoteSymbol) {
		JSONObject symbolsObject = new JSONObject();
		ArrayList<String> pairsStringList = new ArrayList<String>();
		for(int i=0;i<totalPairs;i++) {
			symbolsObject = (JSONObject) jsonArray.get(i);
			if(symbolsObject.get("status").equals("TRADING")) {
				if(symbolsObject.get("quoteAsset").equals(assetQuoteSymbol)) {
					if((Boolean) symbolsObject.get("isSpotTradingAllowed") == true) {
						pairsStringList.add((String) symbolsObject.get("symbol"));
					}
				}
				
			}
		}
		return pairsStringList;
	}
	
	public ArrayList<String> getAllMarginAssetPairs() {
		JSONObject symbolsObject = new JSONObject();
		ArrayList<String> pairsStringList = new ArrayList<String>();
		for(int i=0;i<totalPairs;i++) {
			symbolsObject = (JSONObject) jsonArray.get(i);
			if(symbolsObject.get("status").equals("TRADING")) {
				if((Boolean) symbolsObject.get("isMarginTradingAllowed") == true) {
					pairsStringList.add((String) symbolsObject.get("symbol"));
				}
			}
		}
		return pairsStringList;
	}

}
