package com.dev.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.dev.chart.vo.GlobalData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJSON {
	
	 public static void main(String[] args) {
		 ObjectMapper map = new ObjectMapper();
	     String jStr = "{\r\n" + 
	     		"  \"Global\": {\r\n" + 
	     		"    \"NewConfirmed\": 139803,\r\n" + 
	     		"    \"TotalConfirmed\": 8274306,\r\n" + 
	     		"    \"NewDeaths\": 6829,\r\n" + 
	     		"    \"TotalDeaths\": 451939,\r\n" + 
	     		"    \"NewRecovered\": 97831,\r\n" + 
	     		"    \"TotalRecovered\": 3954518\r\n" + 
	     		"  },\r\n" + 
	     		"  \"Countries\": [\r\n" + 
	     		"    {\r\n" + 
	     		"      \"Country\": \"Afghanistan\",\r\n" + 
	     		"      \"CountryCode\": \"AF\",\r\n" + 
	     		"      \"Slug\": \"afghanistan\",\r\n" + 
	     		"      \"NewConfirmed\": 783,\r\n" + 
	     		"      \"TotalConfirmed\": 26310,\r\n" + 
	     		"      \"NewDeaths\": 13,\r\n" + 
	     		"      \"TotalDeaths\": 491,\r\n" + 
	     		"      \"NewRecovered\": 344,\r\n" + 
	     		"      \"TotalRecovered\": 5508,\r\n" + 
	     		"      \"Date\": \"2020-06-17T15:49:01Z\"\r\n" + 
	     		"    },\r\n" + 
	     		"    {\r\n" + 
	     		"      \"Country\": \"Albania\",\r\n" + 
	     		"      \"CountryCode\": \"AL\",\r\n" + 
	     		"      \"Slug\": \"albania\",\r\n" + 
	     		"      \"NewConfirmed\": 82,\r\n" + 
	     		"      \"TotalConfirmed\": 1672,\r\n" + 
	     		"      \"NewDeaths\": 1,\r\n" + 
	     		"      \"TotalDeaths\": 37,\r\n" + 
	     		"      \"NewRecovered\": 9,\r\n" + 
	     		"      \"TotalRecovered\": 1064,\r\n" + 
	     		"      \"Date\": \"2020-06-17T15:49:01Z\"\r\n" + 
	     		"    }\r\n" + 
	     		"  ],\r\n" + 
	     		"  \"Date\": \"2020-06-17T15:49:01Z\"\r\n" + 
	     		"}";
	    		JSONObject obj = new JSONObject(jStr);
	    		GlobalData data = null;
	    		try {
					 data = map.readValue(obj.get("Global").toString(), GlobalData.class);
				} catch (JsonProcessingException | JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		System.out.println(data);

	   }

}
