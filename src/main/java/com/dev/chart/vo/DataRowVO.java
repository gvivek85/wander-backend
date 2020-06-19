package com.dev.chart.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties({"CountryCode", "Slug", "NewConfirmed", "NewDeaths", "NewRecovered", "empty"})
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
	
	public DataRowVO() {
		
	}

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTotalConfirmed() {
		return totalConfirmed;
	}

	public void setTotalConfirmed(String totalConfirmed) {
		this.totalConfirmed = totalConfirmed;
	}

	public Long getTotalDeaths() {
		return totalDeaths;
	}

	public void setTotalDeaths(Long totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

	public String getTotalRecovered() {
		return totalRecovered;
	}

	public void setTotalRecovered(String totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
}
