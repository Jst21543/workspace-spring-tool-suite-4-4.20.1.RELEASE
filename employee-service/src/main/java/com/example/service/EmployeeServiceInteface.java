package com.example.service;

import org.springframework.stereotype.Component;

import com.example.model.Employee;

@Component
public interface EmployeeServiceInteface {
	public Employee save(Employee emp);
	public Employee get(int id);
	

}
