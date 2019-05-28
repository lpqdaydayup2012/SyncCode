package com.core;

import java.awt.event.MouseWheelEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * author:pagi.liu
 * date:2019-05-28
 */
public class HttpClientHelper {

	// http get«Î«Û
	public static String doGet(String url, int timeout, String charset) {
		HttpURLConnection connection = null;
		InputStream inputStream = null;
		BufferedReader bufferedReader = null;
		String result = null;
		try {
			URL url2 = new URL(url);
			connection = (HttpURLConnection) url2.openConnection();
			connection.setConnectTimeout(timeout);
			connection.setRequestMethod("GET");
			connection.setReadTimeout(timeout);
			connection.connect();
			if (200 == connection.getResponseCode()) {
				inputStream = connection.getInputStream();
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream, charset));
				StringBuffer stringBuffer = new StringBuffer();
				String temp;
				while ((temp = bufferedReader.readLine()) != null) {
					stringBuffer.append(temp);
					stringBuffer.append("\r\n");
				}
				result = stringBuffer.toString();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	// http post«Î«Û
	public void doPost() {

	}

}
