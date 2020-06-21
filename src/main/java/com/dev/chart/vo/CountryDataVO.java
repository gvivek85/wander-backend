package com.dev.chart.vo;

import java.util.Date;

/**
 * This class contains the Country data 
 * @author Vivek Gupta
 *
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDataVO {

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

	/**
	 * Default constructor
	 */
	public CountryDataVO() {

	}

	/**
	 * 
	 * @param country
	 * @param confirmed
	 * @param date
	 * @param countryCode
	 * @param deaths
	 */
	public CountryDataVO(String country, Long confirmed, Date date, String countryCode, Long deaths) {
		super();
		this.country = country;
		this.confirmed = confirmed;
		this.date = date;
		this.countryCode = countryCode;
		this.deaths = deaths;
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
	 * @return the confirmed
	 */
	public Long getConfirmed() {
		return confirmed;
	}

	/**
	 * @param confirmed the confirmed to set
	 */
	public void setConfirmed(Long confirmed) {
		this.confirmed = confirmed;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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
	 * @return the deaths
	 */
	public Long getDeaths() {
		return deaths;
	}

	/**
	 * @param deaths the deaths to set
	 */
	public void setDeaths(Long deaths) {
		this.deaths = deaths;
	}

}
