package com.dev.chart.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is constains the Confirmed Cases data 
 * @author Vivek Gupta
 *
 */
public class ConfirmedCasesVO {

	@JsonProperty
	private String name;

	@JsonProperty
	private List<Long> data;

	/**
	 * Default Constructor
	 */
	public ConfirmedCasesVO() {

	}
	/**
	 * Parameterized Constructor
	 * @param name
	 * @param data
	 */
	public ConfirmedCasesVO(String name, List<Long> data) {
		super();
		this.name = name;
		this.data = data;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the data
	 */
	public List<Long> getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(List<Long> data) {
		this.data = data;
	}
}
