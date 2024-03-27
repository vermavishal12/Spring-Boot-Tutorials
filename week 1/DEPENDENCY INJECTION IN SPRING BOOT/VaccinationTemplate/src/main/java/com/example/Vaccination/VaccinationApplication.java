package com.example.Vaccination;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@SpringBootApplication
public class VaccinationApplication {

    public static void main(String[] args) {

        /*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.

		 Tasks:
		1. Fetch context from ApplicationContext.xml and initiate Scanner.
		2. Fetch vaccine and User type choice.
		3. Get the required bean from context.
		4. Get the appointment details form user
		5. Display the appointment details
		6. Run the loop again to book for another user or else exit.
		 */
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    	TimeAndLocation timeAndLocation = (TimeAndLocation) context.getBean("timeAndLocation");
    	System.out.println("Welcome to the Vaccination Application");
    	while(true) {
        	System.out.println("Please choose your vaccine preference:");
        	
        	System.out.println("1. Covid \n2. Polio \n3. Typhoid");
        	
        	Scanner scanner = new Scanner(System.in);
        	int vaccineChoice = scanner.nextInt();
        	String vaccine = "";
        	if(vaccineChoice == 1) {
        		vaccine = "Covid";
        	} else if(vaccineChoice == 2) {
        		vaccine = "Polio";
        	} else if(vaccineChoice == 3) {
        		vaccine = "Typhoid";
        	} else {
        		break;
        	}
        	
        	System.out.println("Whom do you want to vaccinate");
        	
        	System.out.println("1. Father \n2. Mother \n3. Self \n4. Spouse \n5. Exit");
        	String user = "";
        	int userChoice = scanner.nextInt();
        	if(userChoice == 1) {
        		user = "father";
        	} else if(userChoice == 2) {
        		user = "mother";
        	} else if(userChoice == 3) {
        		user = "self";
        	} else if(userChoice == 4) {
        		user = "spouse";
        	} else {
        		break;
        	}
        	
        	User candidate = (User) context.getBean(user+vaccine);
        	if(!candidate.IsVaccinated()) {
	        	Scanner scannerA = new Scanner(System.in); 
	        	System.out.println("Please enter "+user+" details:");
	        	System.out.println("Name: ");
	        	String name = scannerA.nextLine();
	        	
	        	
	        	System.out.println("Age: ");
	        	int age = scanner.nextInt();
	        	
	        	System.out.println("Appointment date (YYYY-MM-DD): ");
	        	String date = scannerA.nextLine();
	        	
	        	System.out.println("Appointment time (HH:MM AM/PM): ");
	        	String time = scannerA.nextLine();
	        	
	        	System.out.println("Appointmen location: ");
	        	String location = scannerA.nextLine();
	        	
	        	timeAndLocation.setDetails(time, location, date);
	        	
	        	candidate.setUserDetails(name, age, timeAndLocation);
	        	
	        	candidate.setAppointment();
        	} else {
        		System.out.println("User is already vaccinated");
        	}

        	System.out.println("Do you want to register for someone Else");
        	System.out.println("1. Yes \n2. No");
        	int choice = scanner.nextInt();
        	if(choice == 2) {
        		break;
        	}
    	}
    	
    }
}