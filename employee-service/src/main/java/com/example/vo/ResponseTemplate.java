package com.example.vo;

import com.example.model.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplate {
	private Employee emp;
	private Department dept;
	
	

}
