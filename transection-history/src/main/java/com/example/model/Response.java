package com.example.model;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Response {
	private Account account;
	private List<Transections> transections;

}
