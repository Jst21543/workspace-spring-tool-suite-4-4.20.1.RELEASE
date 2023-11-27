package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.Account;
import com.example.model.Withdraw;

@Service
public class WithdrawService {
	@Autowired
	private RestTemplate template;
	
	public String withdraw(Withdraw withdraw) {
		
		//getting account HttpEntity from account template
		HttpEntity<Account> account=template.getForEntity("http://ACCOUNT/account/get/"+withdraw.getAccountnumber(), Account.class);
		//this condition is checking for amount is grater or less 
		if(account.getBody().getAmount()>=withdraw.getAmount()) {
			//here setting amount in account class
			account.getBody().setAmount(account.getBody().getAmount()-withdraw.getAmount());
			//here sending account HttpEntity to account template
			template.exchange("http://ACCOUNT/account/update/"+withdraw.getAccountnumber(),HttpMtehod.POST, account, Account.class);
			//here stting httpHeaders and contentType of response
			HttpHeaders headers=new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			//converting withdraw pojo to HttpEntity 
			HttpEntity<Withdraw>entity=new HttpEntity<>(withdraw,headers);
			//sending withdraw HttpEntity to transections template
			template.exchange("http://TRANSECTIONS/transection/post",HttpMethod.POST,entity, String.class);
			return "withdraw success";
		}
		else {
			return "insuficient balance";
		}
	}

}
