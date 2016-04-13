package com.yahoo.weather.platform;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.yahoo.weather.platform.Utilities;
// to test weather consdition
public class WeatherTest {
	@Test
	public void testgetWeatherCondition() {
		try {
			Utilities ult = new Utilities();
			String baseURL = "https://query.yahooapis.com/v1/public/yql?q=select%20item.condition%20from%20weather.forecast%20where%20woeid%20%3D%202487889&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
			String wPath = "$.query.results.channel.item.condition.text";
			String actualCondition = ult.readJSONData(baseURL, wPath);
			String expectedCondition = "Mostly Cloudy";
			System.out.println("Expected : " + expectedCondition.toString() + "    Actual : " + actualCondition);
			Assert.assertEquals(actualCondition, expectedCondition);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testgetWeatherTemp() {
		try {
			Utilities ult = new Utilities();
			String baseURL = "https://query.yahooapis.com/v1/public/yql?q=select%20item.condition%20from%20weather.forecast%20where%20woeid%20%3D%202487889&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
			String wPath = "$.query.results.channel.item.condition.temp";
			int actualTemp = Integer.parseInt(ult.readJSONData(baseURL, wPath));
			int expectedTemp = 0;
			System.out.println("Expected : " + expectedTemp + "    Actual : " + actualTemp);
			Assert.assertTrue(actualTemp>expectedTemp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
