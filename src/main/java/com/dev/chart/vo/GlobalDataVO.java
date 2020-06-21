package com.dev.chart.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class contains the Global Data Covid
 * @author Vivek Gupta
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GlobalDataVO {

	@JsonProperty("TotalConfirmed")
	private Long totalConfirmed;
	
	@JsonProperty("TotalDeaths")
	private Long totalDeaths;
	
	@JsonProperty("TotalRecovered")
	private String totalRecovered;
	
	/**
	 * 
	 */
	public GlobalDataVO() {
		
	}
	
	/**
	 * @param totalConfirmed
	 * @param totalDeaths
	 * @param totalRecovered
	 */
	public GlobalDataVO(Long totalConfirmed, Long totalDeaths, String totalRecovered) {
		super();
		this.totalConfirmed = totalConfirmed;
		this.totalDeaths = totalDeaths;
		this.totalRecovered = totalRecovered;
	}

	/**
	 * @return the totalConfirmed
	 */
	public Long getTotalConfirmed() {
		return totalConfirmed;
	}

	/**
	 * @param totalConfirmed the totalConfirmed to set
	 */
	public void setTotalConfirmed(Long totalConfirmed) {
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
}
