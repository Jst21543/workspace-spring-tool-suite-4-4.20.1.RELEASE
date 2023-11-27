package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Transections;
@Repository
public interface TransectionRepository extends JpaRepository<Transections, String> {
	public List<Transections> getByAccountnumber(long accountnumber);

}
