package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	public Department getByCode(String code);
}
