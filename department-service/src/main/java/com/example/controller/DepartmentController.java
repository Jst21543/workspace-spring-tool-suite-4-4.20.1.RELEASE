package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Department;
import com.example.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;
	
	@PostMapping("/save")
	public Department save(@RequestBody Department dept) {
		return service.save(dept);
	}
	@GetMapping("/get,{departmentid}")
	public Department get(@PathVariable int departmentid) {
		return service.getByDeptId(departmentid);
	}
	@GetMapping("/find,{code}")
	public Department getByCode(@PathVariable String code) {
		return service.getByCode(code);
	}

}
