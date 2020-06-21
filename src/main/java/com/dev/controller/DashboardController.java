package com.dev.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.chart.vo.ConfirmedCasesVO;
import com.dev.chart.vo.CountryDataVO;
import com.dev.chart.vo.CountryDeathsVO;
import com.dev.chart.vo.DataRowVO;
import com.dev.chart.vo.GlobalDataVO;
import com.dev.config.model.UserPrincipal;
import com.dev.config.response.ApiResponse;
import com.dev.constants.AppConstants;
import com.dev.invoke.external.InvokeExternalService;
import com.dev.security.config.CurrentUser;
import com.dev.service.DashboardService;

/**
 * Dashboard Controller, containing API's for all the Dashboard Graphs.
 * @author Vivek Gupta
 */
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

	private Logger logger = LoggerFactory.getLogger(DashboardController.class);

	@Autowired
	private InvokeExternalService invokeExternalService;

	@Autowired
	private DashboardService dashboardService;

	/**
	 * Method fetches the Top 4 Countries Data for Covid-19
	 * @param userPrincipal
	 * @return
	 */
	@GetMapping("/getTopCountriesData")
	public List getTopCountries(@CurrentUser UserPrincipal userPrincipal){
		Map<String,Object> finalMap=null;
		List<DataRowVO> list = invokeExternalService.getTopCountriesData();

		if(list != null) {
			return list;
		} else {
			logger.error("There is no Covid data for the countries");
		}
		return null;
	}

	/**
	 * This method fetches the Country Specific Data
	 * @param userPrincipal
	 * @param country
	 * @return
	 */
	@GetMapping("/getCountrySpecificData/{country}")
	public List<CountryDataVO> getCountrySpecificData(@CurrentUser UserPrincipal userPrincipal,
			@PathVariable String country){
		List<CountryDataVO> list = invokeExternalService.getCountrySpecificData(country);
		if(list != null) {
			return list;
		} else {
			logger.error("There is no Covid data for country " + country);
		}
		return null;
	}

	@GetMapping("/getSummary")
	public List<ConfirmedCasesVO> getSummary(@CurrentUser UserPrincipal userPrincipal){
		List<ConfirmedCasesVO> list = invokeExternalService.getSummary();
		if(list == null || list.isEmpty()) {
			logger.error("No Data found for Country Summary");
			return null;
		}
		return list;
	}

	@GetMapping("/getGlobalData")
	public GlobalDataVO getGlobalData() {
		return invokeExternalService.getGlobalData();
	}

	@GetMapping("/getCountryDeaths")
	public CountryDeathsVO getCountryDeaths(@CurrentUser UserPrincipal userPrincipal){

		List<DataRowVO> list = invokeExternalService.getTopCountriesData();

		if(list != null && !list.isEmpty()) {
			return dashboardService.filterList(list);
		} else {
			logger.error("No Data found for Country Deaths");
		}
		return null;
	}


}
