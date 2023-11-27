package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	private long accountnumber;
	private String name;
	private long amount;
	private String address;
	private long mobile;
	private long aadhar;
	private String pancard;

}
