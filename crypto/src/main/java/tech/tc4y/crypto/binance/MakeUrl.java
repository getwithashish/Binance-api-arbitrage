package tech.tc4y.crypto.binance;

import java.net.URL;

public class MakeUrl {

	private String urlString;
	private URL url;
	
	public MakeUrl() {
		this.urlString = "https://api.binance.com";
	}
	
	public URL generateUrl(String apiEndpoint) throws Exception {
		urlString = urlString.concat(apiEndpoint);
		url = new URL(urlString);
		return url;
	}
}
