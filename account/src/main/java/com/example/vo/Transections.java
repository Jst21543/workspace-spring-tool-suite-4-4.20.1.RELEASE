package com.example.vo;


import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transections {
	private long accountnumber;
	private String transectiontype;
	private long amount;
	
	
	

}
