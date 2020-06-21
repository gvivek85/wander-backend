package com.dev.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

/**
 * Roles Entity class used to hold the Role Name for User
 * @author Vivek Gupta
 */
@Entity
@Table(name = "ROLES")
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    //@Enumerated(EnumType.STRING)
    @Column(length = 60)
    private String name;
    
    @Column(length = 100)
    private String description;
    
    private Boolean isActive = true;
    
    private Integer status;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ROLE_AUTHORITY",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private List<Authority> authorities = new ArrayList<>();

    public Roles() {

    }

    public Roles(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the authorities
	 */
	public List<Authority> getAuthorities() {
		return authorities;
	}

	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	/**
	 * @return
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
}