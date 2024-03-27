package com.example.tax;

public class IncomeTax implements Tax{
    /*
    1. Create the following attributes.
        a. taxableAmount (double)
        b. taxAmount (double)
        c. isTaxPayed (boolean)
    2. Make this class an implementation of Tax interface and override the interface methods.
    3. Using constructor initialize the isTaxPayed boolean false.
     */
	double taxableAmount;
	
	double taxAmount;
	
	boolean isTaxPayed;
	
	public IncomeTax() {
		this.isTaxPayed = false;
	}
	
	@Override
	public void setTaxableAmount(int amount) {
		this.taxableAmount = amount;
	}
	
	@Override
	public void calculateTaxAmount() {
		if(taxableAmount >= 1500000) {
			this.taxAmount = 0.3*(this.taxableAmount);
		} else if(taxableAmount >= 1200000 && taxableAmount < 1500000) {
			this.taxAmount = 0.2*(this.taxableAmount);
		} else if(taxableAmount >= 900000 && taxableAmount < 1200000) {
			this.taxAmount = 0.15*(this.taxableAmount);
		} else if (taxableAmount >= 600000 && taxableAmount < 900000) {
			this.taxAmount = 0.1*(this.taxableAmount);
		} else if (taxableAmount >= 300000 && taxableAmount < 600000) {
			this.taxAmount = 0.05*(this.taxableAmount);
		} else {
			this.taxAmount = 0;
		}
	}
	
	@Override
	public double getTaxAmount() {
		return this.taxAmount;
	}
	
	@Override
	public String getTaxType() {
		return "income";
	}
	
	@Override
	public boolean isTaxPayed() {
		return this.isTaxPayed;
	}
	
	@Override
	public void payTax() {
		this.isTaxPayed = true;
		System.out.println("Hi, your income tax is paid");
	}
}
