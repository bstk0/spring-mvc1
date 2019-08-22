package br.com.dbe.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetClientPost {
	
	public void doPOST(String sJSON) {

		try {

			URL url = new URL(
					"http://bisterco.pythonanywhere.com/empdb/employee");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			//String input = "{\"qty\":100,\"name\":\"iPad 4\"}";

			OutputStream os = conn.getOutputStream();
			os.write(sJSON.getBytes());
			os.flush();
			
			System.out.println("conn.getResponseCode() ...." + conn.getResponseCode() + "\n");

			if ( (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) && 
				 (conn.getResponseCode() != 200) ){
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				System.out.println(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}
	}	

}
