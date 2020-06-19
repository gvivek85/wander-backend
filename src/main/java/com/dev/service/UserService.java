package com.dev.service;

import java.util.List;

import com.dev.config.model.UserPrincipal;
import com.dev.entity.User;

public interface UserService {

	public UserPrincipal loadUserRolesAuthorities(User user);
	
	User findByUsername(String username);
	
	public List<User> getUserList();
}
