package com.dev.invoke.external;

import java.util.List;

import org.json.JSONObject;

import com.dev.chart.vo.ConfirmedCases;
import com.dev.chart.vo.CountryData;
import com.dev.chart.vo.DataRowVO;
import com.dev.chart.vo.GlobalData;

public interface InvokeExternalService {

	public List<DataRowVO> getTopCountriesData();
	public List<CountryData> getCountrySpecificData(String country);
	public List<ConfirmedCases> getSummary();
	public GlobalData getGlobalData();
}
