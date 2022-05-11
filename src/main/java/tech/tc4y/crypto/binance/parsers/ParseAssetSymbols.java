package tech.tc4y.crypto.binance.parsers;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ParseAssetSymbols {

	private JSONObject jsonObject;
	private JSONArray jsonArray;
	private int totalSymbols;
	
	public ParseAssetSymbols(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
		jsonArray = (JSONArray) this.jsonObject.get("symbols");
		totalSymbols = jsonArray.size();
	}
	
	public ArrayList<String> getAllTradableSpotQuoteAssetSymbols(String assetBaseSymbol) {
		JSONObject symbolsObject = new JSONObject();
		ArrayList<String> symbolsStringList = new ArrayList<String>();
		for(int i=0;i<totalSymbols;i++) {
			symbolsObject = (JSONObject) jsonArray.get(i);
			if(symbolsObject.get("status").equals("TRADING")) {
				if(symbolsObject.get("baseAsset").equals(assetBaseSymbol)) {
					if((Boolean) symbolsObject.get("isSpotTradingAllowed") == true) {
						symbolsStringList.add((String) symbolsObject.get("quoteAsset"));
					}
				}
				
			}
		}
		return symbolsStringList;
	}
}
