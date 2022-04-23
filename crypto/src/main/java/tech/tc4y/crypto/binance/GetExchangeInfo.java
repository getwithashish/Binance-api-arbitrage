package tech.tc4y.crypto.binance;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

public class GetExchangeInfo {
	
	String apiEndpoint;
	URL url;
	public static Logger logger = Logger.getLogger(GetExchangeInfo.class.getName());
	
	public GetExchangeInfo() throws Exception {
		this.apiEndpoint = "/api/v3/exchangeInfo";
		this.url = new MakeUrl().generateUrl(apiEndpoint);
	}
	
	public String sendRequest() throws Exception {
		HttpURLConnection conn = new MakeApiConnection().establishConnection(url);
		int responseCode = conn.getResponseCode();
		String responseStatus = new CheckResponseCode(responseCode).findStatus();
		if(responseStatus.equalsIgnoreCase("Successful Response")) {
			BufferedReader inBufferedReader = new BufferedReader(new InputStreamReader((InputStream)conn.getContent()));
//			logger.info("Response Code: 200");
//			System.out.println("Response: \n"+inBufferedReader.readLine());
			return inBufferedReader.readLine();
		}
		return null;
	}
}
