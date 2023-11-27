package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Department;
import com.example.repository.DepartmentRepository;
@Service
public class DepartmentService implements DepartmentServiceInterface {
	@Autowired
	private DepartmentRepository repo;

	@Override
	public Department save(Department dept) {
		return repo.save(dept);
	}

	@Override
	public Department getByDeptId(int departmentid) {
		return repo.findById(departmentid).get();
	}

	@Override
	public Department getByCode(String code) {
		return repo.getByCode(code);
	}

}
