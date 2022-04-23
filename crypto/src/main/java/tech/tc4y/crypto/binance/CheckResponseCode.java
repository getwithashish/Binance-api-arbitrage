package tech.tc4y.crypto.binance;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckResponseCode {

	private int responseCode;
	
	public CheckResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	
	public String findStatus() {
		if(responseCode > 199 && responseCode < 300) {
			return "Successful Response";
		}
		else if(responseCode > 99 && responseCode < 200) {
			return "Informational Response";
		}
		else if(responseCode > 299 && responseCode < 400) {
			return "Redirectional Response";
		}
		else if(responseCode > 399 && responseCode < 500) {
			return "Client Error Response";
		}
		else if(responseCode > 499 && responseCode < 600) {
			return "Server Error Response";
		}
		Logger logger = Logger.getLogger(getClass().getName());
		logger.log(Level.WARNING, "Response status code is invalid");
		return "Invalid Response";
	}
}
