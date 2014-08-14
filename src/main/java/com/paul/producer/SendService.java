package com.paul.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class SendService {

//	@Autowired
	JmsTemplate jmsTemplate;
	
	public void sendMessage(final String message){
		
		jmsTemplate.send("test.queue",
				         new MessageCreator(){
							public Message createMessage(Session session) throws JMSException{
								return session.createObjectMessage(message);
							}
						}
		
						);
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	
}
	