package com.example.service;

import org.springframework.stereotype.Component;

import com.example.model.Department;

@Component
public interface DepartmentServiceInterface {
	public Department save(Department dept);
	public Department getByDeptId(int departmentid);
	public Department getByCode(String code);

}
