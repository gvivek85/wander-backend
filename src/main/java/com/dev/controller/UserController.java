package com.dev.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.config.model.UserPrincipal;
import com.dev.entity.User;
import com.dev.security.config.CurrentUser;
import com.dev.service.UserService;
import com.dev.value.object.UserSummary;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/userDetails")
	public UserSummary getUserDetails(@CurrentUser UserPrincipal userPrincipal) {
		UserSummary userSummary = new UserSummary(userPrincipal.getId(), userPrincipal.getName(),
					userPrincipal.getUsername(), (List<GrantedAuthority>) userPrincipal.getAuthorities());
				
		logger.info("Returning the logged in user details to the UI");
		return userSummary;
	}
	
	@GetMapping("/getUserList")
	public List<User> getUsers(@CurrentUser UserPrincipal userPrincipal) {
		//if(null != userPrincipal) {
			List<User> userList = userService.getUserList();
			if(null != userList) {
				logger.info("No of Users " + userList.size());
				return userList;
			} else {
				logger.info("No users available in the System");
			}
//		} else { 
//			logger.info("Invalid User request");
//		}
		return null;
	}
}
