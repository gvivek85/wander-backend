package com.dev.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.dev.config.model.UserPrincipal;
import com.dev.entity.User;
import com.dev.security.config.CurrentUser;

/**
 * User Service Interface
 * @author Vivek Gupta
 *
 */
public interface UserService {

	public UserPrincipal loadUserRolesAuthorities(User user);
	
	User findByUsername(String username);
	
	public List<User> getUserList();
	
	public User updateUser(User user);
}
