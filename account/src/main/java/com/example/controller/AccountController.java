package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService service;
	
	@PostMapping("/post")
	public Account save(@RequestBody Account account) {
		return service.save(account);
	}
	@GetMapping("/get/{accountnumber}")
	public Account get(@PathVariable long accountnumber) {
		return service.get(accountnumber);
	}
	@PostMapping("/update/{accountnumber}")
	public String update(@RequestBody Account account,@PathVariable long accountnumber) {
		return service.update(account, accountnumber);
	}

}
