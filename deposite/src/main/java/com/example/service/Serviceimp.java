package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.Account;
import com.example.model.Deposite;
@Service
public class Serviceimp implements DepositeServiceInteface {
	
	//creating object and injecting by autowiring of restTemplate
	@Autowired
	private RestTemplate template;
	
	@Override
	public String deposit(Deposite deposit) {
		//here getting the account details from account template by getForEntity
		HttpEntity<Account> account=template.getForEntity("http://ACCOUNT/account/get/"+deposit.getAccountnumber(), Account.class);
		
		//here i am doing addition operation of money
		account.getBody().setAmount(account.getBody().getAmount()+deposit.getAmount());
		
		//here i'm sending account entity to account template
		template.postForEntity("http://ACCOUNT/account/update/"+deposit.getAccountnumber(), account, Account.class);
		
		//creating HttpHeaders and setContenttype for creating httpEntity
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		//here converting pojo to HttpEntity 
		HttpEntity<Deposite> entity=new HttpEntity<Deposite>(deposit, headers);
		
		//here exchanging HttpEntity between this template to Transactions template.
		template.exchange("http://TRANSECTIONS/transection/post",HttpMethod.POST, entity, String.class);
		
		//i'm returning a string 
		return "Deposited";
		
	
	}
	

}
