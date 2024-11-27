package com.myapp.assignment11;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class Assignment11Application {
	public static void main(String[] args) {
		SpringApplication.run(Assignment11Application.class, args);
	}

	// Test my own beans
	// output. But why created two times?
	/*
	 * MyBean instance created
	 * MyBeanConsumer created
	 * myBean hashcode = 2145420209
	 * MyBean instance created
	 * MyBeanConsumer created
	 * myBean hashcode = 641664202
	 */
	private void myBeanTest() {
		MyBean myBean;
		MyBeanConsumer myBeanConsumer;
		myBean = new MyBean();
		myBeanConsumer = new MyBeanConsumer(myBean);
		myBean.greet();
		myBeanConsumer.greet();
	}

	/*
	 * TODO:
	 * - Create a @PostConstruct method to be executed after spring container has
	 * completed configuration.
	 * - Invite input using Scanner and System.in for value "to" and "message".
	 * - Set the input to setup(string, string) method in NotificationService.java.
	 * - Invoke send() method in Notification.java.
	 */

	// Notification instances
	@Autowired
	private NotificationService SMSNotificationService;
	//@Autowired
	//private NotificationService EmailNotificationService; // Get input from console

	// Post initialization of main app.
	@PostConstruct
	public void getNotification() {
		// get input
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input your message to be sent:");
		System.out.print("To: ");
		String to = scanner.nextLine();
		System.out.print("Message: ");
		String message = scanner.nextLine();
		// close the scanner
		scanner.close();

		// Choose SMS or Email
		// Set notification to SMS
		System.out.println("Sending message by SMS ...");
		SMSNotificationService.setup(to, message);
		SMSNotificationService.send();

		// Set notification to Email
		// System.out.println("Sending message by Email ...");
		// EmailNotificationService.setup(to, message);
		// EmailNotificationService.send();

		// get my beans
		//myBeanTest();
	}

} // end of class
