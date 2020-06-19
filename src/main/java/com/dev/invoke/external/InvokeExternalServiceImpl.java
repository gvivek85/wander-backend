package com.dev.invoke.external;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.dev.chart.vo.ConfirmedCasesVO;
import com.dev.chart.vo.CountryDataVO;
import com.dev.chart.vo.DataRowVO;
import com.dev.chart.vo.GlobalDataVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class InvokeExternalServiceImpl implements InvokeExternalService {

	private Logger logger = LoggerFactory.getLogger(InvokeExternalServiceImpl.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${fetch.top.country.data.url}")
	private String countryDataUrl;

	@Value("${fetch.country.specific.data}")
	private String countrySpecificUrl;
	
	@Value("${fetch.country.summary.url}")
	private String summaryUrl;
	
	@Value("${fetch.num.of.days}")
	private int noOfDays;

	@Override
	public List<DataRowVO> getTopCountriesData() {
		Object obj = null;
		String jsonStr = null;
		try {
			jsonStr = restTemplate.getForObject(countryDataUrl, String.class);
			return convertToJsonString(jsonStr);
		} catch (RestClientException ex) {
			logger.error("Error while fetching data for top 10 countries " + ex.getMessage());
		}

		return null;
	}

	private List<DataRowVO> convertToJsonString(String str) {
		DataRowVO dataVo = null;
		List<DataRowVO> list = new ArrayList<DataRowVO>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			JSONObject json = new JSONObject(str);
			JSONArray array = json.getJSONArray("Countries");
			for(int i = 0 ; i < array.length() ; i++){
				dataVo = mapper.readValue(array.getJSONObject(i).toString(), DataRowVO.class);
				list.add(dataVo);
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return list;
	}

	@Override
	public List<CountryDataVO> getCountrySpecificData(String country) {
		Object obj = null;
		String jsonStr = null;
		CountryDataVO cData = null;
		List<CountryDataVO> cDataList = new ArrayList<CountryDataVO>();
		
		try {
			jsonStr =  restTemplate.getForObject(countrySpecificUrl+country, String.class);

			ObjectMapper map = new ObjectMapper();
			JSONArray array = new JSONArray(jsonStr);
			for(int i = 0 ; i < array.length() ; i++){
				cData = map.readValue(array.getJSONObject(i).toString(), CountryDataVO.class);
				cDataList.add(cData);
			}
			Collections.sort(cDataList, Collections.reverseOrder((c1,c2)-> {
				return c1.getDate().compareTo(c2.getDate());
			}));
			//return cDataList;
			return countryData(cDataList);
		} catch (JsonProcessingException | JSONException | RestClientException ex) {
			logger.error("Error while fetching data for top 10 countries " + ex.getMessage());
		}
		return null;
	}

	private List<CountryDataVO> countryData(List<CountryDataVO> cDataList){
		List<CountryDataVO> confirmedList = new ArrayList<CountryDataVO>();
		CountryDataVO data1 = null;
		if(cDataList != null && !cDataList.isEmpty()) {
			for(int i=0;i<7;i++) {
				data1 = new CountryDataVO();
				data1.setCountry(cDataList.get(i).getCountry());
				data1.setDate(cDataList.get(i).getDate());
				data1.setConfirmed(cDataList.get(i).getConfirmed()/10000);
				data1.setDeaths(cDataList.get(i).getDeaths()/100);
				confirmedList.add(data1);
			}
		}
		Collections.sort(confirmedList,(c1,c2)-> {
			return c1.getDate().compareTo(c2.getDate());
		});
		return confirmedList;
	}
	
	public List<ConfirmedCasesVO> getSummary() {
		List<ConfirmedCasesVO> casesList = new ArrayList<ConfirmedCasesVO>();
		
		List<CountryDataVO> indiaList = getCountrySpecificData("India");
		List<CountryDataVO> usList = getCountrySpecificData("united-states");
		List<CountryDataVO> brList = getCountrySpecificData("Brazil");
		List<CountryDataVO> rusList = getCountrySpecificData("Russia");
		
		if(indiaList != null && !indiaList.isEmpty()) {
			casesList.add(filterCountryList("India", indiaList));
		}
		if(usList != null && !usList.isEmpty()) {
			casesList.add(filterCountryList("USA", usList));
		}
		if(brList != null && !brList.isEmpty()) {
			casesList.add(filterCountryList("Brazil", brList));
		}
		if(rusList != null && !rusList.isEmpty()) {
			casesList.add(filterCountryList("Russia", rusList));
		}
		return casesList;
	}
	
	private ConfirmedCasesVO filterCountryList(String countryName, List<CountryDataVO> countryList) {
		ConfirmedCasesVO obj = new ConfirmedCasesVO();
		List<Long> confirmedCasesList = new ArrayList<Long>();
		obj.setName(countryName);
		//obj.setData(countryList);
		countryList.forEach(item->{
			//confirmedCasesList.add(item.)
			confirmedCasesList.add(item.getConfirmed());
		});
		obj.setData(confirmedCasesList);
		return obj;
	}
	
	public GlobalDataVO getGlobalData() {
		String jsonStr = null;
		try {
			jsonStr = restTemplate.getForObject(countryDataUrl, String.class);
			return fetchGlobalData(jsonStr);
			//return convertToJsonUsingGson(jsonStr);
		} catch (RestClientException ex) {
			logger.error("Error while fetching data for top 10 countries " + ex.getMessage());
		}

		return null;
	}
	
	private GlobalDataVO fetchGlobalData(String str) {
		GlobalDataVO gData = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			JSONObject json = new JSONObject(str);
			gData = mapper.readValue(json.get("Global").toString(), GlobalDataVO.class);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return gData;
	}
}
