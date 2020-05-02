package com.roboto.response;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class App {

	public static void main(String[] args) throws Exception {

		String httpsURL = "http://data.fixer.io/api/latest?access_key=624f124a129b443738df43ee90cfe288&base=EUR&symbols=USD";

		URL myUrl = new URL(httpsURL);

		HttpURLConnection conn = (HttpURLConnection) myUrl.openConnection();

		InputStream is = conn.getInputStream();

		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String input = br.readLine();
		//String input = "{\"success\":true,\"timestamp\":1585350545,\"base\":\"EUR\",\"date\":\"2020-03-27\",\"rates\":{\"USD\":1.116689}}";
		System.out.println(input);
		
		Gson gson = new Gson();
		Currency currency = gson.fromJson(input, Currency.class);
		String base = currency.getBase();
		String date = currency.getDate();
		Rates rate = currency.getRates();
		Double usd = rate.getUSD();
		System.out.println(base);
		System.out.println(date);
		System.out.println(usd);
		System.out.println(currency.getSuccess());
		System.out.println(currency.getTimestamp());
		
		
		

		br.close();
	}

}
