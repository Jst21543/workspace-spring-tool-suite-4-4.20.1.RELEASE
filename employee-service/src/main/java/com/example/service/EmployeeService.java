package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
@Service
public class EmployeeService implements EmployeeServiceInteface {
	@Autowired
	private EmployeeRepository repo;
	@Override
	public Employee save(Employee emp) {
		return repo.save(emp);
	}
	@Override
	public Employee get(int id) {
		
		return repo.findById(id).get();
	}
	

}
