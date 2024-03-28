package com.codingNinjas.Bank.Account.Registration;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/**
  This class is an implementation of a "Account" Interface based on the selection 
  done in the console for account type. You need to complete this class
  based on the following tasks.

     Tasks:
   a. Create attribute amount(double) 
   b. Override the methods of Account Interface.
   c. Build the logic for all the methods based on the description mentioned in the Account Interface.

**/

@Component("savingsAccount")
@Scope("prototype")
public class savingsAccount implements Account{

	private String accountType = "Savings";
	private double amount = 0;
	
	@PostConstruct
	public void init() {
		System.out.println("SavingsAccount bean has been instantiated and I'm the init() method");
	}
	
	@Override
	public String getAccountType() {
		return this.accountType;
	}

	@Override
	public void addBalance(double balance) {
		this.amount = balance;
		
	}

	@Override
	public double getBalance() {
		return this.amount;
	}

	@PreDestroy
	public void destroy() {
		System.out.println("SavingsAccount bean has been closed and I'm the destroy() method");
	}

}
