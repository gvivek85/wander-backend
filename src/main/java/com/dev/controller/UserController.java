package com.dev.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.config.model.UserPrincipal;
import com.dev.entity.User;
import com.dev.security.config.CurrentUser;
import com.dev.service.UserService;
import com.dev.value.object.UserSummary;

/**
 * User Controller class used for fetching User Details
 * and List of Users
 * @author Vivek Gupta
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * This method returns the UserSummary Object 
	 * @param userPrincipal
	 * @return
	 */
	@GetMapping("/userDetails")
	public UserSummary getUserDetails(@CurrentUser UserPrincipal userPrincipal) {
		UserSummary userSummary = new UserSummary(userPrincipal.getId(), userPrincipal.getUsername(),
					userPrincipal.getName(),userPrincipal.getEmail(), (List<GrantedAuthority>) userPrincipal.getAuthorities());
				
		logger.info("Returning the logged in user details to the UI");
		return userSummary;
	}
	
	/**
	 * This method returns the Users List
	 * @param userPrincipal
	 * @return
	 */
	@GetMapping("/getUserList")
	public List<User> getUsers(@CurrentUser UserPrincipal userPrincipal) {
		if(null != userPrincipal) {
			List<User> userList = userService.getUserList();
			if(null != userList) {
				logger.info("No of Users " + userList.size());
				return userList;
			} else {
				logger.info("No users available in the System");
			}
		} else { 
			logger.info("Invalid User request");
		}
		return null;
	}
	
	/**
	 * Api Method to update the User Object
	 * @param userPrincipal
	 * @param user
	 * @return
	 */
	@PostMapping("/updateUser")
	public User updateUser(@CurrentUser UserPrincipal userPrincipal, @RequestBody User user) {
		return userService.updateUser(user);
	}
}
