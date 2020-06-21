package com.dev.config.response;

import java.util.Map;

/**
 * APiResponse Class that contains the details of the response.
 * @author Vivek Gupta
 */
public class ApiResponse {

	private Boolean success;
	
	private Long responseCode;
	
	private String responseMsg;
	
	private Map<String,Object> finalMap;
	
	/**
	 * @param success
	 * @param responseCode
	 * @param responseMsg
	 * @param finalMap
	 */
	public ApiResponse(boolean success, Long responseCode, String responseMsg, Map<String, Object> finalMap) {
		this.success = success;
		this.responseCode = responseCode;
		this.responseMsg = responseMsg;
		this.finalMap = finalMap;
	}

	/**
	 * 
	 */
	public ApiResponse() {
		
	}

	
	/**
	 * @return the success
	 */
	public Boolean getSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	/**
	 * @return the finalMap
	 */
	public Map<String, Object> getFinalMap() {
		return finalMap;
	}

	/**
	 * @param finalMap the finalMap to set
	 */
	public void setFinalMap(Map<String, Object> finalMap) {
		this.finalMap = finalMap;
	}

	/**
	 * @return the responseCode
	 */
	public Long getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(Long responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the responseMsg
	 */
	public String getResponseMsg() {
		return responseMsg;
	}

	/**
	 * @param responseMsg the responseMsg to set
	 */
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	
}
