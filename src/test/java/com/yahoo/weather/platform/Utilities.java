package com.yahoo.weather.platform;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.jayway.jsonpath.JsonPath;

public class Utilities {
	public String readJSONData(String url, String jpath) throws IOException {
		String response = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpPost httpSet = new HttpPost(url);
			CloseableHttpResponse response1 = httpclient.execute(httpSet);
			try {
				System.out.println(response1.getStatusLine());
				HttpEntity entity1 = response1.getEntity();
				//System.out.println("entity1--->>>" + entity1);
				String body = EntityUtils.toString(entity1);
				//System.out.println("body--->>>" + body);
				response = JsonPath.parse(body).read(jpath);
				//System.out.println("weather--->>>" + weather);

			} finally {
				response1.close();
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			httpclient.close();
		}
		return response;
	}
}
