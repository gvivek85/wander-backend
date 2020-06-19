package com.dev.chart.vo;

import java.util.HashSet;
import java.util.List;

public class CountryDeaths {
	
	private HashSet<String> countryList;
	
	private HashSet<Long> noOfDeaths;
	
	public CountryDeaths() {
		
	}

	public CountryDeaths(HashSet<String> countryList, HashSet<Long> noOfDeaths) {
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
