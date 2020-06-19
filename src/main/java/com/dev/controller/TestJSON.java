package com.dev.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.dev.chart.vo.GlobalData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJSON {
	
	 public static void main(String[] args) {
		 ObjectMapper map = new ObjectMapper();
			String jsonStr = null;
			RestTemplate restTemplate = new RestTemplate();
			try {
				jsonStr = restTemplate.getForObject("http://corona.lmao.ninja/v2/continents?yesterday=true&sort", String.class);
				//return convertToJsonString(jsonStr);
				//return convertToJsonUsingGson(jsonStr);
			} catch (RestClientException ex) {
				//logger.error("Error while fetching data for top 10 countries " + ex.getMessage());
			}
			
	    		//JSONObject obj = new JSONObject(jsonStr);
	    		JSONArray jArr = new JSONArray(jsonStr);
	    		for(int i=0; i<jArr.length(); i++) {
	    			System.out.println("Continent -> " + ((JSONObject)jArr.get(i)).getString("continent"));
	    			
	    		}
	    		
//	    		GlobalData data = null;
//	    		try {
//					 data = map.readValue(obj.get("Global").toString(), GlobalData.class);
//				} catch (JsonProcessingException | JSONException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//	    		System.out.println(data);

	   }

}
