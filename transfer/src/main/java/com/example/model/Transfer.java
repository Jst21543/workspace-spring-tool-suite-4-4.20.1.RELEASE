package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Transfer {
	@Id
	private Long accountnumber;
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String transectionid;
	private long amount;
	private long toaccountnumber;
	

}
