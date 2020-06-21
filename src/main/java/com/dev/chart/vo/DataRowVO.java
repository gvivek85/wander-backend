package com.dev.chart.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class contains the Country Row Data for all the countries 
 * @author Vivek Gupta
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataRowVO {

	@JsonProperty("CountryCode")
	private String countryCode;
	
	@JsonProperty("Country")
	private String country;
	
	@JsonProperty("TotalConfirmed")
	private String totalConfirmed;
	
	@JsonProperty("TotalDeaths")
	private Long totalDeaths;
	
	@JsonProperty("TotalRecovered")
	private String totalRecovered;
	
	@JsonProperty("Date")
	private String date;

	/**
	 * Default Constructor
	 */
	public DataRowVO() {

	}

	/**
	 * @param country
	 * @param totalConfirmed
	 * @param totalDeaths
	 * @param totalRecovered
	 * @param date
	 * @param countryCode
	 */
	public DataRowVO(String country, String totalConfirmed, Long totalDeaths, String totalRecovered, String date,
			String countryCode) {
		super();
		this.country = country;
		this.totalConfirmed = totalConfirmed;
		this.totalDeaths = totalDeaths;
		this.totalRecovered = totalRecovered;
		this.date = date;
		this.countryCode = countryCode;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the totalConfirmed
	 */
	public String getTotalConfirmed() {
		return totalConfirmed;
	}

	/**
	 * @param totalConfirmed the totalConfirmed to set
	 */
	public void setTotalConfirmed(String totalConfirmed) {
		this.totalConfirmed = totalConfirmed;
	}

	/**
	 * @return the totalDeaths
	 */
	public Long getTotalDeaths() {
		return totalDeaths;
	}

	/**
	 * @param totalDeaths the totalDeaths to set
	 */
	public void setTotalDeaths(Long totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

	/**
	 * @return the totalRecovered
	 */
	public String getTotalRecovered() {
		return totalRecovered;
	}

	/**
	 * @param totalRecovered the totalRecovered to set
	 */
	public void setTotalRecovered(String totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
}
