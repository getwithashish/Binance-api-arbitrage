package tech.tc4y.crypto.binance;

import java.util.ArrayList;

public class OrderController {

	public static void main(String args[]) throws Exception {
//		GetOrderBook getOrderBook = new GetOrderBook("BNBUSDT",10);
//		getOrderBook.sendRequest();
		
		GetExchangeInfo getExchangeInfo = new GetExchangeInfo();
		String exchangeInfoString = getExchangeInfo.sendRequest();
		
		ExchangeInfoJsonParse exchangeInfoJsonParse = new ExchangeInfoJsonParse(exchangeInfoString);
		ArrayList<String> allTradablePairs =  exchangeInfoJsonParse.getTradableSpotAssetPairs("BNB");
		System.out.println("All Tradable pairs of BNB: \n");
		for (String symbol : allTradablePairs) {
			System.out.println(symbol + ", ");
		}
		System.out.println("Number of Tradable Pairs: "+ allTradablePairs.size());
	}
}
