package tech.tc4y.crypto.binance.apiutils;

import java.util.ArrayList;

public class CreateAssetPair {
	
	public ArrayList<String> createPair(ArrayList<String> symbolsStringList, String symbol){
		ArrayList<String> assetPairArrayList = new ArrayList<String>();
		for(String symbolsItem : symbolsStringList) {
			assetPairArrayList.add(symbolsItem.concat(symbol));
		}
		return assetPairArrayList;
	}
	
	public ArrayList<String> createPair(String symbol, ArrayList<String> symbolsStringList){
		ArrayList<String> assetPairArrayList = new ArrayList<String>();
		for(String symbolsItem : symbolsStringList) {
			assetPairArrayList.add(symbol.concat(symbolsItem));
		}
		return assetPairArrayList;
	}

}
