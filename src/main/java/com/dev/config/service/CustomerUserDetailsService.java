package com.dev.config.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.dev.entity.User;
import com.dev.repository.UserRepository;
import com.dev.service.UserService;
import com.dev.config.model.UserPrincipal;

/**
 * Customer User Detail Service class implementing the UserDetailsService
 * interface using which we can load the User on Authentication 
 * @author Vivek Gupta
 */
@Service
public class CustomerUserDetailsService implements UserDetailsService {
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;

	/**
	 * Method that locates the user based on the username and then
	 * return the UserDetails.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
    	UserPrincipal userPrincipal = userService.loadUserRolesAuthorities(user);
    	return userPrincipal;
	}
}