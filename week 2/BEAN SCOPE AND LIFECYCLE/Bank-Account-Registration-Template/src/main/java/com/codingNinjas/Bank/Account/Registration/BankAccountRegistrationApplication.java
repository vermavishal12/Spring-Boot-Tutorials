package com.codingNinjas.Bank.Account.Registration;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class BankAccountRegistrationApplication {

	public static void main(String[] args) {

		/*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.
		
		* 1. Fetch context from ApplicationContext.xml and initiate scanner.
		* 2. Get user details from console.
		* 3. Get account details from user and add them to the account list.
		* 4. Display the list of accounts with their reference ids.
		*/
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		System.out.println("Welcome to Account Registration Application!");
		
		System.out.println("Please enter your name");
		
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		User user = (User) context.getBean("myUser");
		user.setUserDetails(name);
		String isMore="";
		while(true) {
			
			System.out.println("Do you want to add " + isMore +"account \n1. Yes \n2. No");
			Scanner scannerB = new Scanner(System.in);
			int choice = scannerB.nextInt();
			if(choice != 1) {
				break;
			}
			System.out.println("Please select the account type \n1. Current \n2. Savings");
			
			choice = scannerB.nextInt();
			String accountType= "";
			if(choice == 1) {
				accountType = "currentAccount";
			} else {
				accountType = "savingsAccount";
			}
			
			Account account = (Account) context.getBean(accountType);
			System.out.println("Enter the opening balance");
			Scanner scannerC = new Scanner(System.in);
			double amount = scannerC.nextDouble();
			
			account.addBalance(amount);
			user.addAccount(account);
			isMore = "more ";
		}
		
		
		System.out.println("Hi " + user.getName() + ", here is the list of your accounts: ");
		
		List<Account> accountList = user.getAllAccounts();
		
		for(int i = 0; i < accountList.size() ; i++) {
			Account account = accountList.get(i);
			String parts[] = account.toString().split("@");
			System.out.println(account.getAccountType() + " : opening balance - " + account.getBalance() + " Reference Id @" + parts[1]);
		}
		
		
		
		
	}

}
