package com.example.service;

import com.example.entity.Account;

public interface AccountServiceInterface {
	public Account save(Account account);
	public Account get(long accountnumber);
	public String update(Account account,long accountnumber);
}
