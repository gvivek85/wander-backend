package com.dev.value.object;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

/**
 * User Summary object for sending the User details back 
 * @author Vivek Gupta
 */
public class UserSummary {

	private Long userId;

	private String username;
	
	private String name;
	
	private String email;

	private List<GrantedAuthority> authorities;

	/**
	 * @param userId
	 * @param username
	 * @param name
	 * @param email
	 * @param authorities
	 */
	public UserSummary(Long userId, String username, String name, String email, List<GrantedAuthority> authorities) {
		super();
		this.userId = userId;
		this.username = username;
		this.name = name;
		this.email = email;
		this.authorities = authorities;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the authorities
	 */
	public List<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
}
