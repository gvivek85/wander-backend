package com.dev.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.config.model.UserPrincipal;
import com.dev.security.config.CurrentUser;
import com.dev.value.object.UserVO;

@RestController
@RequestMapping("/user/")
@CrossOrigin
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/userDetails")
	public UserVO getUserDetails(@CurrentUser UserPrincipal userPrincipal) {
		UserVO userVO = new UserVO(userPrincipal.getId(), userPrincipal.getName(),
					userPrincipal.getUsername(), (List<GrantedAuthority>) userPrincipal.getAuthorities());
				
		logger.info("Returning the logged in user details to the UI");
		return userVO;
	}
	
	@GetMapping("/userInfo")
	public UserVO getUserDetails() {
		UserVO userVO = new UserVO(1L, "Vivek", "vivek85", null);
		logger.info("Returning the logged in user details to the UI");
		return userVO;
	}
}
