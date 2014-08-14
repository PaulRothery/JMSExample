package com.paul.dao;


import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.paul.model.Account;

public class AccountDaoImpl extends HibernateDaoSupport implements AccountDao{
	 
	public void save(Account account){
		getSession().save(account);
		getSession().flush();
	}
 
	public void update(Account account){
		getHibernateTemplate().update(account);
	}
 
	public void delete(Account account){
		getHibernateTemplate().delete(account);
	}
 
	@SuppressWarnings("unchecked")
	public Account findByAccountCode(String accountCode){

		List<Account> list = getHibernateTemplate().find(
                      "from Account where accountCode=?",accountCode);
		return (Account)list.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Account> listAll() {
		return getHibernateTemplate().find("from Account");


	}
 
}