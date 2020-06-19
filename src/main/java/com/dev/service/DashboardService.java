package com.dev.service;

import java.util.List;

import javax.transaction.SystemException;

import com.dev.chart.vo.CountryDeaths;
import com.dev.chart.vo.DataRowVO;
import com.dev.entity.User;

public interface DashboardService {

	public Boolean saveUser(User user) throws SystemException;
	
	public boolean checkUserByEmail(String tempEmailId);
	
	public CountryDeaths filterList(List<DataRowVO> list);
}
