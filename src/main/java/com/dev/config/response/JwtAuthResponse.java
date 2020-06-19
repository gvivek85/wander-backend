package com.dev.config.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtAuthResponse {

	private String accessToken;
    private String tokenType = "Bearer";
    private Long expiresIn;
    
    public JwtAuthResponse(String accessToken){
    	this.accessToken = accessToken;
    }
    public JwtAuthResponse() {
    	
    }
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public Long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}
}
