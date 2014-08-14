package com.paul.service;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.transaction.annotation.Transactional;

import com.paul.dao.AccountDao;
import com.paul.model.Account;


public class AccountService 
{
    AccountDao accountDao;
	
	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Transactional
	public void insertAccount(String firstName, String lastName, String dateOfBirth) {
		  
    	Account account = new Account();
    	account.setFirstName(firstName);
    	account.setLastName(lastName);
    	
    	DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
    	java.util.Date date = null;
		try {
			date = format.parse(dateOfBirth);
		} catch (ParseException e) {
			e.printStackTrace();
		}

    	java.sql.Date sqlDate = new java.sql.Date(date.getTime());

    	account.setDateOfBirth(sqlDate);
        accountDao.save(account);
       	   	
    	System.out.println("Added " + firstName + " " + lastName + " " + dateOfBirth);

    	
	}
}