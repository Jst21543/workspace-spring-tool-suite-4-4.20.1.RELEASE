package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.Transfer;
import com.example.repository.TransferRepository;
import com.example.vo.Account;
import com.example.vo.Transections;




@Service
public class TransferService {
	//autowiring the objects to respected class variables
	@Autowired
	private RestTemplate template;
	@Autowired
	private TransferRepository repo;
	@Autowired
	private Transections transection;
	
	public String transfer(Transfer trans) {
		String res="";
		
		//getting account details by parsing the account number to account template
		Account from=template.getForObject("http://ACCOUNT/account/get/"+trans.getAccountnumber(), Account.class);
		Account to=template.getForObject("http://ACCOUNT/account/get/"+trans.getToaccountnumber(), Account.class);
		
		//setting the of the value of transactions class
		transection.setAmount(trans.getAmount());
		
		//this condition is for checking the amount 
		if(from.getAmount()>trans.getAmount()) {
			
			//here i'm doing subtraction operation to amount sending account
			from.setAmount(from.getAmount()-trans.getAmount());
			
			//here i'm doing addition operation to amount receiving account
			to.setAmount(to.getAmount()+trans.getAmount());
			
			//creating HttpHeaders and SetContenttype to HttpResponse
			HttpHeaders headers=new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			//creating HttpEntitys for sending the account details
			HttpEntity<Account> entity1=new HttpEntity<>(from,headers);
			HttpEntity<Account> entity2=new HttpEntity<>(to,headers);
			
			//setting values of transaction remaining values
			transection.setTransectiontype("debit");
			transection.setAccountnumber(trans.getAccountnumber());
			
			//here converting Transactions pojo class to HttpEntity for exchanging between to templates
			HttpEntity<Transections> transfer=new HttpEntity<>(transection,headers);
			
			//here i'm exchanging Trancetion httpEntity to transections template
			template.exchange("http://TRANSECTIONS/transection/post", HttpMethod.POST, transfer, String.class);
			
			//here i'm exchanging account httpEntity to account template
			template.exchange("http://ACCOUNT/account/update/"+trans.getAccountnumber(), HttpMethod.POST, entity1, String.class);
			
			//here i'm setting values transectiontype and amount of a transactions class
			transection.setTransectiontype("credit");
			transection.setAccountnumber(trans.getToaccountnumber());
			
			//here converting Transactions pojo class to HttpEntity for exchanging between to this template and transections template
			HttpEntity<Transections>tranfer2=new HttpEntity<>(transection,headers);
			
			//here sending transactions HttpEntity to transitions template
			template.exchange("http://TRANSECTIONS/transection/post", HttpMethod.POST, tranfer2, String.class);
			
			//here sending account HttpEntity to AccountTemplate
			template.exchange("http://ACCOUNT/account/update/"+trans.getToaccountnumber(), HttpMethod.POST, entity2, String.class);
			//assigning value to res variable
			res="transfer success";
			//saving transaction in database
			repo.save(trans);
		}
		else {
			res="insuficient balance";
		}
		return res;
	}
	

}
