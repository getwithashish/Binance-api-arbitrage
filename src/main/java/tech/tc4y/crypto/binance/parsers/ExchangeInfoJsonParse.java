package tech.tc4y.crypto.binance.parsers;

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
		ParseAssetPairs parseAssetPairs = new ParseAssetPairs(jsonObject);
		ArrayList<String> tradableSpotAssetPairs = parseAssetPairs.getAllTradableSpotAssetPairs(assetSymbol);
		return tradableSpotAssetPairs;
	}
	
	public ArrayList<String> getTradableSpotQuoteAssetSymbols(String baseAssetSymbol){
		ParseAssetSymbols parseAssetSymbols = new ParseAssetSymbols(jsonObject);
		ArrayList<String> tradableSpotQuoteAssetSymbols = parseAssetSymbols.getAllTradableSpotQuoteAssetSymbols(baseAssetSymbol);
		return tradableSpotQuoteAssetSymbols;
	}
}
