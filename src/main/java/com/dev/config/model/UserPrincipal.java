package com.dev.config.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * UserPrincipal Class that holds the logged in User details
 * @author Vivek Gupta
 *
 */
public class UserPrincipal implements UserDetails {
	
    private Long id;

    private String name;

    private String username;

    @JsonIgnore
    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;
    
    private List<String> newAuthorities;

    /**
     * @param id
     * @param name
     * @param username
     * @param email
     * @param password
     * @param authorities
     */
    public UserPrincipal(Long id, String name, String username, String email, String password, 
    			Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    /**
     * @param id
     * @param name
     * @param username
     * @param email
     * @param password
     */
    public UserPrincipal(Long id, String name, String username, String email, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    
    /**
     * 
     */
    public UserPrincipal() {
    	super();
	}

    /**
     * @return
     */
    public Long getId() {
        return id;
    }
    
    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * 
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * 
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * 
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    
    /**
     * 
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
    
    /**
     * 
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }
    
    /**
     * 
     */
    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

	/**
	 * @return the newAuthorities
	 */
	public List<String> getNewAuthorities() {
		return newAuthorities;
	}

	/**
	 * @param newAuthorities the newAuthorities to set
	 */
	public void setNewAuthorities(List<String> newAuthorities) {
		this.newAuthorities = newAuthorities;
	}
    
    
    
    
}