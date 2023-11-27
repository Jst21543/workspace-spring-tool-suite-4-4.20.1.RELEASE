package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Deposite;
import com.example.service.Serviceimp;

@RestController
@RequestMapping("/deposite")
public class DepositeController {
	@Autowired
	private Serviceimp service;
	@PostMapping("/update")
	public String deposite(@RequestBody Deposite deposit) {
		deposit.setTransectiontype("deposit");
		return service.deposit(deposit);
	}
}
