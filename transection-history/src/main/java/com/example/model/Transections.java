package com.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transections {
	
	private String date;
	private long accountnumber;
	private String transectiontype;
	private long amount;
	
	
	

}
