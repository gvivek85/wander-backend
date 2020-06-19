package com.dev.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.transaction.SystemException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dev.entity.User;
import com.dev.repository.RolesRepository;
import com.dev.repository.UserRepository;
import com.dev.chart.vo.CountryDeathsVO;
import com.dev.chart.vo.DataRowVO;
import com.dev.constants.AppConstants;
import com.dev.entity.Roles;

@Service
public class DashboardServiceImpl implements DashboardService {
	
	private Logger logger = LoggerFactory.getLogger(DashboardServiceImpl.class);

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RolesRepository rolesRepository;
	
	@Override
	public Boolean saveUser(User user) throws SystemException{
		Boolean isSuccess = false;
		List<Roles> userRoles = null;
		try {
			userRoles = rolesRepository.findByName(AppConstants.ROLE_VIEW_DASHBOARD);
			
			if(userRoles != null && !userRoles.isEmpty()) {
				user.setRoles(userRoles);
				user.setPassword(bcryptEncoder.encode(user.getPassword()));
				userRepository.save(user);
				isSuccess = true;
			} else {
				logger.error("No roles found in the database ");
			}
		} catch (Exception ex) {
			
		}
		return isSuccess;
	}

	public boolean checkUserByEmail(String emailId) {
		return userRepository.findByEmail(emailId)!= null;
	}
	
	public CountryDeathsVO filterList(List<DataRowVO> list) {
		List<DataRowVO> filteredList = new ArrayList<DataRowVO>();
		
		CountryDeathsVO obj = new CountryDeathsVO();
		
		HashSet<String> countryList = new HashSet<String>();
		HashSet<Long> noOfDeaths = new HashSet<Long>();
		
		list.forEach(item->{
			if(Arrays.stream(AppConstants.countryArr).anyMatch(item.getCountryCode()::equals)) {
				countryList.add(item.getCountry());
				noOfDeaths.add(item.getTotalDeaths());
			}
		});
		
		obj.setCountryList(countryList);
		obj.setNoOfDeaths(noOfDeaths);

		return obj;
	}
}
