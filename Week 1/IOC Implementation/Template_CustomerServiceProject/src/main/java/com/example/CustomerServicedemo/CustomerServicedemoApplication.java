package com.example.CustomerServicedemo;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.Customers.CustomerCare;

@SpringBootApplication
public class CustomerServicedemoApplication {

	public static void main(String[] args) {

		/*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.

			 Tasks:
		 *  1. Load the beans from ApplicationContext.xml
		 *  2. Display all the departments available and get the input from user.
		 *  3. Get the message from user and store it into the respective department.
		 *  
		 */
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("Welcome to our Customer Care application");
		System.out.println("Please enter your name: ");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.println("Thanks for reaching us "+ name);
		
		System.out.println("Please select a department to connect to: \n1. Payment Department \n2. Query Department \n3. Sales Department \n0. Exit");
		int choice = scanner.nextInt();
		String department ;
		switch(choice) {
			case 1:
				department = "paymentDepartment";
				break;
			case 2:
				department = "queryDepartment";
				break;
			case 3:
				department = "salesDepartment";
				break;
			case 0:
				return;
			default:
				return;
		}
		
		CustomerCare customer = (CustomerCare) context.getBean(department);
		
		customer.setCustomerName(name);
		customer.getService();
		Scanner scan = new Scanner(System.in);
		String issue = scan.nextLine();
		customer.setProblem(issue);
		customer.getProblem();
		
	}
}
