package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import com.example.vo.Transections;
@Service
public class AccountService implements AccountServiceInterface {
	@Autowired
	private AccountRepository repo;
	@Autowired
	private Transections transection;
	@Autowired
	private RestTemplate template;

	@Override
	public Account save(Account account) {
		//saving account to database
		
		//setting the values for transactions class
		transection.setAccountnumber(account.getAccountnumber());
		transection.setAmount(account.getAmount());
		transection.setTransectiontype("credit");
		
		//creating httpHeaders and set content type for sending the entity 
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		//converting normal pojo class to HttpEntity
		HttpEntity<Transections> entity=new HttpEntity<>(transection,headers);
		//exchanging HttpEntitys between to templates
		template.exchange("http://TRANSECTIONS/transection/post", HttpMethod.POST, entity, String.class);
		//here i am returning a String
		return repo.save(account);
	}

	@Override
	public Account get(long accountnumber) {
		//getting details from database
		return repo.findById(accountnumber).get();
	}

	@Override
	public String update(Account account,long accountnumber) {
		//updating the account 
		repo.save(account);
		return "account updated";
		
	}
	

}
