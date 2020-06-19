package com.dev.chart.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryData {

	@JsonProperty("Country")
	private String country;
	
	@JsonProperty("Confirmed")
	private Long confirmed;
	
	@JsonProperty("Date")
	private Date date;
	
	@JsonProperty("CountryCode")
	private String countryCode;
	
	@JsonProperty("Deaths")
	private Long deaths; 
	
	public CountryData() {
		
	}

	public CountryData(String country, Long confirmed, Date date, String countryCode, Long deaths) {
		super();
		this.country = country;
		this.confirmed = confirmed;
		this.date = date;
		this.countryCode = countryCode;
		this.deaths = deaths;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Long confirmed) {
		this.confirmed = confirmed;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Long getDeaths() {
		return deaths;
	}

	public void setDeaths(Long deaths) {
		this.deaths = deaths;
	}
	
}
