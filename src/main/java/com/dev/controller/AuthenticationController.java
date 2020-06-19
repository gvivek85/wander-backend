package com.dev.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.SystemException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.config.response.ApiResponse;
import com.dev.config.response.JwtAuthResponse;
import com.dev.config.service.CustomerUserDetailsService;
import com.dev.entity.User;
import com.dev.security.config.JwtTokenProvider;
import com.dev.service.DashboardService;
import com.dev.service.UserService;
import com.dev.value.object.LoginVO;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthenticationController {
	
	private Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private CustomerUserDetailsService customerDetailsService;
	
	@Autowired
	private DashboardService dashboardService;
	
	@Autowired
	private UserService userService;

	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginVO loginRequest,HttpServletRequest request) throws Exception {
		ApiResponse apiResponse = null;
		Authentication authentication = null;
		try {
			if(!(userService.findByUsername(loginRequest.getUsername())!=null)) {
				logger.error("User Doesn't exist in the System ");
				apiResponse = new ApiResponse(false, 1004L,"User Doesn't exist in the System.", null);   
				return ResponseEntity.ok((apiResponse));
			}
			 authentication =  
					authenticationManager.authenticate(
							new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), 
									loginRequest.getPassword()));
			
		} catch (DisabledException ex) {
			logger.error("User is Disabled " + ex.getMessage());
			apiResponse = new ApiResponse(false, 1004L,"User id disabled.", null);   
			return ResponseEntity.ok((apiResponse));
		} catch (BadCredentialsException ex) {
			apiResponse = new ApiResponse(false, 1004L,"Invalid User credentials.",null);   
			logger.error("Invalid User credentials " + ex.getMessage());
			return ResponseEntity.ok((apiResponse));
		} catch (Exception ex) {
			apiResponse = new ApiResponse(false, 1004L,"Invalid User credentials .",null);   
			logger.error("Invalid User credentials " + ex.getMessage());
			return ResponseEntity.ok((apiResponse));
		}
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetails userDetails = customerDetailsService.loadUserByUsername(loginRequest.getUsername());
		String token = jwtTokenProvider.generateToken(userDetails);
		return ResponseEntity.ok(new JwtAuthResponse(token));
	}
	
	@PostMapping("/registerUser")
	public ResponseEntity<?> registerUser(@RequestBody @Valid User user ) {
		Boolean isSuccess = true;
		String returnMessage = "Records saved successfully";
		String emailId = user.getEmail();
		if(null != emailId && !emailId.isEmpty()) {
			if(dashboardService.checkUserByEmail(emailId)) {
				return ResponseEntity.ok(new ApiResponse(false, 1004L, "User with emailId : " + emailId +" already exists.", null));
			}
		}
		try {
			isSuccess = dashboardService.saveUser(user);
		} catch (SystemException ex) {
			logger.error("Error while saving user information " + ex.getMessage());
		}
		return ResponseEntity.ok(new ApiResponse(isSuccess, 1000L, returnMessage, null));
	}

}