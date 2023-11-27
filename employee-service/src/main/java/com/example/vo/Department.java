package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
	
	private int departmentid;
	private String departmentname;
	private String address;
	private String code;

}
