package com.paul.producer;

import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SendMessage {

    static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		ConfigurableApplicationContext context = 
		new ClassPathXmlApplicationContext(new String[] {"jmsContext.xml"});

		SendService sendService = (SendService)context.getBean("sendService");

		String another = "Y";
		while (!another.equalsIgnoreCase("N")) {
			another = getUserInput(sendService);   
		}
	    	    
		System.exit(0);
	}

	private static String getUserInput(SendService sendService) {
		String another;
		System.out.println("Enter first name:");			
		String firstName = scanner.nextLine();   
		
		System.out.println("Enter last name:");
		String lastName = scanner.nextLine();
		
		System.out.println("Enter date of birth (mm/dd/yyyy):");
		String dob = scanner.nextLine();
		sendService.sendMessage(firstName + ":" + lastName + ":" + dob);

		System.out.println("Enter another account (Y/N):");			
		another = scanner.nextLine();
		return another;
	}

}
