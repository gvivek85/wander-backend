package com.dev.chart.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConfirmedCasesVO {
	@JsonProperty
	private String name;
	
	@JsonProperty
	private List<Long> data;
	
	public ConfirmedCasesVO() {
		
	}
	public ConfirmedCasesVO(String name, List<Long> data) {
		super();
		this.name = name;
		this.data = data;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Long> getData() {
		return data;
	}
	public void setData(List<Long> data) {
		this.data = data;
	}
	
	
	

}
