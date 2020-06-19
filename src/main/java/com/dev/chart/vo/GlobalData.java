package com.dev.chart.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GlobalData {

	@JsonProperty("TotalConfirmed")
	private Long totalConfirmed;
	
	@JsonProperty("TotalDeaths")
	private Long totalDeaths;
	
	@JsonProperty("TotalRecovered")
	private String totalRecovered;
	
	public GlobalData() {
		
	}
	public GlobalData(Long totalConfirmed, Long totalDeaths, String totalRecovered) {
		super();
		this.totalConfirmed = totalConfirmed;
		this.totalDeaths = totalDeaths;
		this.totalRecovered = totalRecovered;
	}

	public Long getTotalConfirmed() {
		return totalConfirmed;
	}

	public void setTotalConfirmed(Long totalConfirmed) {
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
}
