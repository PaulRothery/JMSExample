package com.paul.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.activemq.command.ActiveMQMessage;
import org.springframework.transaction.annotation.Transactional;

import com.paul.service.AccountService;

public class AccountMessageListener implements MessageListener {

	public AccountService accountService;
	
	@Transactional
	public void onMessage(Message message) {
		try {
			ActiveMQMessage am = (ActiveMQMessage) message;
			ObjectMessage om = (ObjectMessage) message;
			
			System.out.println("Listener Correlation : " + message.getJMSCorrelationID());
			System.out.println("Listener Timestamp   : " + message.getJMSTimestamp());
			System.out.println("Listener Id          : " + message.getJMSMessageID());
			System.out.println("AM Id          : " + am.getJMSMessageID());
			System.out.println("AM mime        : " + am.getJMSXMimeType());
			System.out.println("AM Content     : " + am.getContent());
			System.out.println("AM Destination : " + am.getDestination());
			System.out.println("OM Object      : " + om.getObject());
			
			String[] sa = om.getObject().toString().split(":");
			System.out.println("sa[0]      : " + sa[0]);
			System.out.println("sa[1]      : " + sa[1]);
			System.out.println("sa[2]      : " + sa[2]);
					
			accountService.insertAccount(sa[0], sa[1], sa[2]);

				    
		} catch (JMSException ex) {
			throw new RuntimeException(ex);
		}
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}



	
}
