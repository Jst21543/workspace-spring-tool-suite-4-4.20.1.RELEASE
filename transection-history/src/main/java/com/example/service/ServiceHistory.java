package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.Account;
import com.example.model.Response;
import com.example.model.Transections;

@Service
public class ServiceHistory {
	//i'm autowiring the object to respected Class variables
	@Autowired
	private RestTemplate template;
	@Autowired
	private Response response;
	
	public Response get(long accountnumber) {
		
		//here getting account details and store into account variable
		Account account=template.getForObject("http://ACCOUNT/account/get/"+accountnumber, Account.class);
		
		//here i'm converting the response of the RestTemplate to what we mention class in exchange syntax
		template.getMessageConverters();
		
		//here i'm getting the responseEntity generic type is List format  
		ResponseEntity<java.util.List<Transections>>  list=template.exchange("http://TRANSECTIONS/transection/get/"+accountnumber, HttpMethod.GET, null, new ParameterizedTypeReference<java.util.List<Transections>>() {});
		
		//here i'm setting one of the value in response
		response.setAccount(account);
		
		//here i'm extracting list from responseEntity by getBody method
		java.util.List<Transections> finalList=list.getBody();
		
		//here i'm setting another value of response
		response.setTransections(finalList);
		
		//here i'm returning response
		return response;
	}

}
