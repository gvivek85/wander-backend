package com.dev.value.object;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;


public class UserSummary {

	private Long userId;
	private String username;
	private String name;

	private List<GrantedAuthority> authorities;
	
	
	public UserSummary(Long userId, String username, String name, List<GrantedAuthority> authorities) {
		super();
		this.userId = userId;
		this.username = username;
		this.name = name;
		this.authorities = authorities;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<GrantedAuthority> getAuthorities() {
		return authorities;
	}


	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

}
