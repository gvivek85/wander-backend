package com.dev.service;

import javax.transaction.SystemException;

import com.dev.entity.User;

public interface DashboardService {

	public Boolean saveUser(User user) throws SystemException;
	
	public boolean checkUserByEmail(String tempEmailId);
}
