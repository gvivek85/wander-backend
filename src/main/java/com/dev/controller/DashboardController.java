package com.dev.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.chart.vo.ConfirmedCases;
import com.dev.chart.vo.CountryData;
import com.dev.chart.vo.DataRowVO;
import com.dev.chart.vo.GlobalData;
import com.dev.config.model.UserPrincipal;
import com.dev.config.response.ApiResponse;
import com.dev.constants.AppConstants;
import com.dev.invoke.external.InvokeExternalService;
import com.dev.security.config.CurrentUser;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin
public class DashboardController {
	
	private Logger logger = LoggerFactory.getLogger(DashboardController.class);

	@Autowired
	private InvokeExternalService invokeExternalService;
	
	@GetMapping("/getTopCountriesData")
	public List getTopCountries(@CurrentUser UserPrincipal userPrincipal){
		ApiResponse apiResponse = null;
		Map<String,Object> finalMap=null;
		
		List<DataRowVO> list = invokeExternalService.getTopCountriesData();
		
		if(list != null) {
			finalMap = new HashMap<String, Object>();
			finalMap.put("COUNTRY_DATA", list);
			apiResponse = new ApiResponse(true, 1000L, "Data fetched Successfully", finalMap );
		} else {
			apiResponse = new ApiResponse(true, 1000L, "Data fetched Successfully", finalMap);
		}
		return list;
	}
	
	@GetMapping("/getCountrySpecificData/{country}")
	public List<CountryData> getCountrySpecificData(@CurrentUser UserPrincipal userPrincipal,
			@PathVariable String country){
		ApiResponse apiResponse = null;
		Map<String,Object> finalMap=null;
		
		List<CountryData> list = invokeExternalService.getCountrySpecificData(country);
		
		if(list != null) {
			finalMap = new HashMap<String, Object>();
			finalMap.put("COUNTRY_DATA", list);
			apiResponse = new ApiResponse(true, 1000L, "Data fetched Successfully", finalMap );
		} else {
			apiResponse = new ApiResponse(true, 1000L, "Data fetched Successfully", finalMap);
		}
	
		return list;
	}
	
	@GetMapping("/getSummary")
	public List<ConfirmedCases> getSummary(@CurrentUser UserPrincipal userPrincipal){
		ApiResponse apiResponse = null;
		Map<String,Object> finalMap=null;
		
		List<ConfirmedCases> list = invokeExternalService.getSummary();
		
		if(list == null || list.isEmpty()) {
			logger.error("No Data found for Country Summary");
			return null;
		}
		return list;
	}
	
	@GetMapping("/getGlobalData")
	public GlobalData getGlobalData() {
		return invokeExternalService.getGlobalData();
	}
	
}
