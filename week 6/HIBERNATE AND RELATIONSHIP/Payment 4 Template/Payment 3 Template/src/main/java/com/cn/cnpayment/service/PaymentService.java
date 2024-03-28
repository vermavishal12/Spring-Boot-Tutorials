package com.cn.cnpayment.service;

import com.cn.cnpayment.dal.PaymentDAL;
import com.cn.cnpayment.exception.ElementAlreadyExistException;
import com.cn.cnpayment.exception.InvalidInputException;
import com.cn.cnpayment.exception.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.cnpayment.entity.Payment;
import com.cn.cnpayment.entity.PaymentReview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PaymentService {

	@Autowired
	PaymentDAL paymentDAL;

	@Transactional
	public Payment getPaymentById(int id) {

		Payment payment=paymentDAL.getById(id);

		if(payment==null)
		{
			throw new NotFoundException("No payment found with id:  "+id);
		}
		return payment;
	}

	@Transactional
	public List<Payment> getPaymentByPaymentType(String paymentType) {

		ArrayList<String> validPayments = new ArrayList<String>() {{
				add("Cash");
				add("Cheques");
				add("DebitCard");
				add("CreditCard");
			}};
		Boolean isValidPayment=false;
		for(String validPayment : validPayments)
		{
			if(validPayment.equalsIgnoreCase(paymentType))
			{
				isValidPayment=true;
				break;
			}
		}
		if(isValidPayment==false)
		{
			throw new InvalidInputException("Payment type "+ paymentType + "is incorrect");
		}
		List<Payment> payment = paymentDAL.getByPaymentType(paymentType);

		if(payment==null)
		{
			throw new NotFoundException("No payments found having paymentType: "+paymentType);
		}
		return payment;
	}

	@Transactional
	public List<Payment> getPaymentByDescriptionKeyword(String keyword) {

		List<Payment> payments = paymentDAL.getByPaymentDescription(keyword);
		if(payments==null)
		{
			throw new NotFoundException("No payments found, with description having keyword: "+keyword);
		}
		return payments;
	}

	@Transactional
	public List<Payment> getAllPaymentsByCurrency(String currency) {
		/**
		1. This method returns the list of payment by the given currency.
        2. It only accepts the following currency in any format i.e. LowerCase/UpperCase.
		3. "INR","Rupee","Dollar","Yen","Pound","USD".
		4. It throws InvalidInputException if a currency different from above is received.
		**/
		List<String> validCurrency = new ArrayList<> ();
		Collections.addAll(validCurrency, "INR","Rupee","Dollar","Yen","Pound","USD");
		boolean isValid= false;
		for(String currencies : validCurrency) {
			if(currencies.equalsIgnoreCase(currency)) {
				isValid = true;
				break;
			}
		}
		if(!isValid) {
			throw new InvalidInputException("Invalid Currency type " + currency);
		}
		List<Payment> payment = paymentDAL.getAllPaymentsByCurrency(currency);
		
		if(payment == null) {
			throw new NotFoundException("No payment with the currency type " + currency + " can be found");
		}
		return payment;
	}

	@Transactional
	public List<Payment> getAllPayments() {

		List<Payment> payment = paymentDAL.getAllPayments();
		if(payment==null)
		{
			throw new NotFoundException("No payments found.");
		}
		return payment;
	}

	@Transactional
	public void addPayment(Payment payment)  {
		if (paymentDAL.getById(payment.getId())!=null){
			throw new ElementAlreadyExistException("Payment already exists");
		}
		paymentDAL.addPayment(payment);
	}

	@Transactional
	public void update(Payment updatePayment) {
		 paymentDAL.update(updatePayment);
	}

	@Transactional
	public void updateDescription(int id, String description) {
		paymentDAL.updateDescription(id,description);
	}

	@Transactional
	public void delete(int id) {
		paymentDAL.delete(id);
	}
	
	@Transactional
	public List<PaymentReview> getPaymentReviews(int paymentId) {
		/**
		 1. This method fetches the list of all PaymentReview associated with the given paymentId.
		 2. It throws NotFoundException if no PaymentReview is found for the given id.
		 **/
		
		List<PaymentReview> paymentReview = paymentDAL.getPaymentReviews(paymentId);
		if(paymentReview == null) {
			throw new NotFoundException("No review exist in the database for the record id " + paymentId);
		}
		return paymentReview;
	}

	@Transactional
	public List<Payment> getAllPaymentsByQueryType(String queryType) {
    /**
		1. This method fetches the list of all Payment for the given queryType.
	    2. Only the following query types are allowed if invalid type are passed the method throws InvalidInputException.
	    3. "Payment Issue","Bank Issue","Merchant Issue" : Both Lowercase and Uppercase formats are accepted.
	**/
		System.out.println("Service layer....");
		List<String>validQueryTypes = new ArrayList<String> ();
		Collections.addAll(validQueryTypes, "Payment Issue", "Bank Issue", "Merchant Issue");
		boolean isValid = false;
		for(String query : validQueryTypes) {
			if(query.equalsIgnoreCase(queryType)) {
				isValid = true;
				break;
			}
		}
		
		if(!isValid) {
			System.out.println("not valid query type");
			throw new InvalidInputException("The query type is not valid");
		}
		
		List<Payment> paymentList = paymentDAL.getAllPaymentsByQueryType(queryType);
		if(paymentList == null) {
			System.out.println("empty list");
			throw new NotFoundException("Can't found the payment with query type in payment");
		}
		
		return paymentList;
		
	}

}

