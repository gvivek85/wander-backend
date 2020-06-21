package com.dev.service;

import java.util.List;

import javax.transaction.SystemException;

import com.dev.chart.vo.CountryDeathsVO;
import com.dev.chart.vo.DataRowVO;
import com.dev.entity.User;

/**
 * Dashboard Service Interface
 * @author Vivek Gupta
 *
 */
public interface DashboardService {

	public Boolean saveUser(User user) throws SystemException;
	
	public boolean checkUserByEmail(String tempEmailId);
	
	public CountryDeathsVO filterList(List<DataRowVO> list);
}
