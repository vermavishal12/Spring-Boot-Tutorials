package com.example.Customers;

import java.util.Random;

/*
     This class is an implementation of a CustomerCare Interface based on the selection 
     in the console the department type is selected.You need to complete this class 
     based on the following tasks.

     Tasks:
       1. Override the methods of CustomerCare Interface:
       2. Build your logic for all the method based on the description given in CustomerCare Interface.
 */
public class SalesDepartment implements CustomerCare {

	private String department = "Sales Department";
	private String customerName;
	private String issue;
	private double refId;
	
	SalesDepartment(){
		Random rand = new Random();
		  
    	this.refId = rand.nextInt(10000);
	}
	
	@Override
	public String  getDepartment() {
		return this.department;
	}

	@Override
	public void getService() {
		System.out.println("Welcome to "+ this.department + this.customerName + ".");
		System.out.println("How may I assist you with your sales inquiry?");
	}
	
	@Override
	public void setCustomerName(String name) {
		this.customerName = name;
	}
	
	@Override
	public void setProblem(String problem) {
		this.issue = problem;
	}
	
	@Override 
	public void getProblem() {
		System.out.println("Dear " + this.customerName + " your issue for "+ this.issue + "has been recorded, your reference id is: "+this.refId);
	}


}
