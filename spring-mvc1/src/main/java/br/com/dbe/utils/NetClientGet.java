package br.com.dbe.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetClientGet {
	
	public String getPy() {
		return getURIContent("http://bisterco.pythonanywhere.com/empdb/employee");
	}

	private String getURIContent(String urlString) {
		String output = "";
		StringBuilder stringBuilder = new StringBuilder();
		try {

			// URL url = new URL("http://localhost:8080/RESTfulExample/json/product/get");
			//URL url = new URL("http://bisterco.pythonanywhere.com/empdb/employee");
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				System.out.println("Output from Server Error\n");
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				stringBuilder.append(output);
				System.out.println(output);
			}
			conn.disconnect();
			return stringBuilder.toString();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return stringBuilder.toString();

	}

}
