package com.dev.chart.vo;

import java.util.HashSet;
import java.util.List;

public class CountryDeathsVO {
	
	private HashSet<String> countryList;
	
	private HashSet<Long> noOfDeaths;
	
	public CountryDeathsVO() {
		
	}

	public CountryDeathsVO(HashSet<String> countryList, HashSet<Long> noOfDeaths) {
		super();
		this.countryList = countryList;
		this.noOfDeaths = noOfDeaths;
	}

	public HashSet<String> getCountryList() {
		return countryList;
	}

	public void setCountryList(HashSet<String> countryList) {
		this.countryList = countryList;
	}

	public HashSet<Long> getNoOfDeaths() {
		return noOfDeaths;
	}

	public void setNoOfDeaths(HashSet<Long> noOfDeaths) {
		this.noOfDeaths = noOfDeaths;
	}

}
