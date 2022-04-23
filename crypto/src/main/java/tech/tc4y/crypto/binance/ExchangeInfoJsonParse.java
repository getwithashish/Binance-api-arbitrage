package tech.tc4y.crypto.binance;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ExchangeInfoJsonParse {
	
	private String response;
	private JSONParser jsonParser;
	private JSONObject jsonObject;
	
	public ExchangeInfoJsonParse(String response) throws Exception {
		this.response = response;
		this.jsonParser = new JSONParser();
		this.jsonObject = (JSONObject) jsonParser.parse(this.response);
	}
	
	public ArrayList<String> getTradableSpotAssetPairs(String assetSymbol) {
		GetAssetPairs getAssetPairs = new GetAssetPairs(jsonObject);
		ArrayList<String> tradableSpotAssetPairs = getAssetPairs.getAllTradableSpotAssetPairs(assetSymbol);
		return tradableSpotAssetPairs;
	}
}
