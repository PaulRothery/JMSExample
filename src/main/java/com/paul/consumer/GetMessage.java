package com.paul.consumer;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetMessage {
	
	 ;

	public static void main(String[] args) {

		ConfigurableApplicationContext context = 
		new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml", "jmsContext.xml", "listenerContext.xml"});
	
	
	}

}
