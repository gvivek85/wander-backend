package com.dev.invoke.external;

import java.util.List;

import org.json.JSONObject;

import com.dev.chart.vo.ConfirmedCasesVO;
import com.dev.chart.vo.CountryDataVO;
import com.dev.chart.vo.DataRowVO;
import com.dev.chart.vo.GlobalDataVO;

public interface InvokeExternalService {

	public List<DataRowVO> getTopCountriesData();
	public List<CountryDataVO> getCountrySpecificData(String country);
	public List<ConfirmedCasesVO> getSummary();
	public GlobalDataVO getGlobalData();
}
