package com.example.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.model.Transections;

@Component
public interface TransectionServiceInterface {
	public Transections save(Transections transection);
	public List<Transections> get(long accountnumber);

}
