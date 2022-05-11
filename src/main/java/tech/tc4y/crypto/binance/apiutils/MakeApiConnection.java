package tech.tc4y.crypto.binance.apiutils;

import java.net.HttpURLConnection;
import java.net.URL;

public class MakeApiConnection {

	private HttpURLConnection conn;
	
	public HttpURLConnection establishConnection(URL url) throws Exception {
		conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		return conn;
	}
}
