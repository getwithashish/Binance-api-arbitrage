package tech.tc4y.crypto.binance.data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

import tech.tc4y.crypto.binance.apiutils.CheckResponseCode;
import tech.tc4y.crypto.binance.apiutils.MakeApiConnection;
import tech.tc4y.crypto.binance.apiutils.MakeUrl;

public class GetOrderBook {
	
	String apiEndpoint;
	String symbol;
	int limit;
	URL url;
	public static Logger logger  = Logger.getLogger(GetOrderBook.class.getName());
	
	public GetOrderBook(String symbol, int limit) throws Exception {
		this.apiEndpoint = "/api/v3/depth";
		this.symbol = symbol;
		this.limit = limit;
		this.apiEndpoint = this.apiEndpoint.concat("?symbol="+symbol+"&limit="+limit);
		this.url = new MakeUrl().generateUrl(apiEndpoint);
	}
	
	public void sendRequest() throws Exception {
		HttpURLConnection conn = new MakeApiConnection().establishConnection(url);
		int responseCode = conn.getResponseCode();
		String responseStatus = new CheckResponseCode(responseCode).findStatus();
		if(responseStatus.equalsIgnoreCase("Successful Response")) {
			BufferedReader inBufferedReader = new BufferedReader(new InputStreamReader((InputStream)conn.getContent()));
			logger.info("Response Code: 200");
			System.out.println("Response: \n"+inBufferedReader.readLine());
		}
	}
}
