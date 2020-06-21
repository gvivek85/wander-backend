package com.dev.config.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * JWT Token Response Class
 * @author Vivek Gupta
 */
public class JwtAuthResponse {

	private String accessToken;

	private String tokenType = "Bearer";

	private Long expiresIn;

	/**
	 * 
	 */
	public JwtAuthResponse() {

	}
	/**
	 * @param accessToken
	 */
	public JwtAuthResponse(String accessToken){
		this.accessToken = accessToken;
	}
	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}
	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	/**
	 * @return the tokenType
	 */
	public String getTokenType() {
		return tokenType;
	}
	/**
	 * @param tokenType the tokenType to set
	 */
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	/**
	 * @return the expiresIn
	 */
	public Long getExpiresIn() {
		return expiresIn;
	}
	/**
	 * @param expiresIn the expiresIn to set
	 */
	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}
}
