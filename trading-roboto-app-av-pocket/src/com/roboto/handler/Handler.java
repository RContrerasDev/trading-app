package com.roboto.handler;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;

public class Handler {

	public static final String URL = "https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=EUR&to_currency=USD&apikey=1Q9Y9OFWO9NZMTBE";
	public static final String URL2 = "https://www.alphavantage.co/query?function=FX_INTRADAY&from_symbol=EUR&to_symbol=USD&interval=1min&apikey=1Q9Y9OFWO9NZMTBE";

	static public Double getUSDRate() {

		Double bid = null;
		Double ask = null;
		Double result = null;
		// Create a new HttpClient and Post Header
	    HttpClient httpclient = HttpClientBuilder.create().build();
	    HttpGet request = new HttpGet(URL);

	    try {
	        // Execute HTTP Post Request
	        ResponseHandler<String> responseHandler=new BasicResponseHandler();
	        String responseBody = httpclient.execute(request, responseHandler);
	        JSONObject response = new JSONObject(responseBody);
	        
	        bid = response.getJSONObject("Realtime Currency Exchange Rate").getDouble("8. Bid Price");
	        ask = response.getJSONObject("Realtime Currency Exchange Rate").getDouble("9. Ask Price");
	        //System.out.println("BID: " + bid);
	        //System.out.println("ASK: " + ask);
	        result = (bid + ask) / 2;
	        result = (double)Math.round(result * 1000000d) / 1000000d;
	        //System.out.println(result);
	        	        
	    } catch (ClientProtocolException e) {
	    	System.out.println(e.getStackTrace());
	    } catch (IOException e) {
	    	System.out.println(e.getStackTrace());
	    } catch (JSONException e) {
	    	System.out.println(e.getStackTrace());
		}
	
	    return result;
		
	}
	
	public static void main(String[] args) {
		
		
		//getUSDRate();
		//System.out.println(getUSDRate());
		
		
	}

	
	
	

}
