package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Transfer;
import com.example.service.TransferService;


@RestController
@RequestMapping("/transfer")
public class TransferController {
	@Autowired
	private TransferService service;
	
	@PostMapping("/post")
	public String transfer(@RequestBody Transfer tranfer) {
		return service.transfer(tranfer);
	}
	
	

}
