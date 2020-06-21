package com.dev.chart.vo;

import java.util.HashSet;
import java.util.List;

/**
 * This class contains the Country data 
 * @author Vivek Gupta
 *
 */
public class CountryDeathsVO {

	private List<String> countryList;

	private List<Long> noOfDeaths;

	/**
	 * Default Constructor
	 */
	public CountryDeathsVO() {

	}
	/**
	 * @param countryList
	 * @param noOfDeaths
	 */
	public CountryDeathsVO(List<String> countryList, List<Long> noOfDeaths) {
		super();
		this.countryList = countryList;
		this.noOfDeaths = noOfDeaths;
	}

	/**
	 * @return the countryList
	 */
	public List<String> getCountryList() {
		return countryList;
	}

	/**
	 * @param countryList the countryList to set
	 */
	public void setCountryList(List<String> countryList) {
		this.countryList = countryList;
	}

	/**
	 * @return the noOfDeaths
	 */
	public List<Long> getNoOfDeaths() {
		return noOfDeaths;
	}

	/**
	 * @param noOfDeaths the noOfDeaths to set
	 */
	public void setNoOfDeaths(List<Long> noOfDeaths) {
		this.noOfDeaths = noOfDeaths;
	}

}
