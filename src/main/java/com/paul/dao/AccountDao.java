package com.paul.dao;

import java.util.List;

import com.paul.model.Account;

public interface AccountDao {
	 
	void save(Account account);
	void update(Account account);
	void delete(Account account);
	Account findByAccountCode(String accountCode);
    List<Account> listAll();
 
}