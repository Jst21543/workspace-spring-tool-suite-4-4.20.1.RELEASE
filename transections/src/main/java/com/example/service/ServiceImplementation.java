package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Transections;
import com.example.repository.TransectionRepository;
@Service
public class ServiceImplementation implements TransectionServiceInterface {
	@Autowired
	private TransectionRepository repo;

	@Override
	public Transections save(Transections transection) {
		//saving the transaction in database
		return repo.save(transection);
	}

	@Override
	public List<Transections> get(long accountnumber) {
		//getting the transitions by account number
		return repo.getByAccountnumber(accountnumber);
	}

}
