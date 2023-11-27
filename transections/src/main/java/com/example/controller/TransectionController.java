package com.example.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Transections;
import com.example.service.ServiceImplementation;

@RestController
@RequestMapping("/transection")
public class TransectionController {
	@Autowired
	private ServiceImplementation service;
	
	@PostMapping("/post")
	public String save(@RequestBody Transections transection) {
		DateTimeFormatter datetime= DateTimeFormatter.ofPattern("dd/mm/yyyy hh-mm-ss");
		LocalDateTime local=LocalDateTime.now();
		String now=datetime.format(local);
		transection.setDate(now);
		service.save(transection);
		return "saved";
	}
	@GetMapping("/get/{accountnumber}")
	public List<Transections> get(@PathVariable long accountnumber){
		return service.get(accountnumber);
	}

}
