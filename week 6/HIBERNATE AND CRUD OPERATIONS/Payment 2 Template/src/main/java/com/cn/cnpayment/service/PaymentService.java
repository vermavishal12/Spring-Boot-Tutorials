package com.cn.cnpayment.service;

import com.cn.cnpayment.dal.PaymentDAL;
import com.cn.cnpayment.entity.Payment;
import com.cn.cnpayment.exception.ElementAlreadyExistException;
import com.cn.cnpayment.exception.InvalidInputException;
import com.cn.cnpayment.exception.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
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
			add("Debit");
			add("Credit");
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
	// 1. Complete the method body for updating a payment object.
	// 2. add proper annotation for registering this method as a Transaction
//		if(updatePayment == null) {
//			throw new InvalidInputException("Not valid payment object");
//		}
//		
//		ArrayList<String> validPayments = new ArrayList<String>() {{
//			add("Cash");
//			add("Debit");
//			add("Credit");
//		}};
//		Boolean isValidPayment=false;
//		for(String validPayment : validPayments)
//		{
//			if(validPayment.equalsIgnoreCase(updatePayment.getPaymentType()))
//			{
//				isValidPayment=true;
//				break;
//			}
//		}
//		if(isValidPayment==false)
//		{
//			throw new InvalidInputException("Payment type "+ updatePayment.getPaymentType() + "is incorrect");
//		}
//		
//		if(paymentDAL.getById(updatePayment.getId()) == null) {
//			throw new NotFoundException("The payment with paymentId: " + updatePayment.getId());
//		}
		
		paymentDAL.update(updatePayment);
	}


	@Transactional
	public void updateDescription(int id, String description) {
	// 	1. Complete the method body for updating description of a payment.
	//	2. add proper annotation for registering this method as a Transaction
//		if(paymentDAL.getById(id) == null) {
//			throw new NotFoundException("The payment with paymentId: " + id);
//		}
//		
		paymentDAL.updateDescription(id, description);
	}


	@Transactional
	public void delete(int id) {
	//	1. Complete the method body for deleting payment.
	//	2. add proper annotation for registering this method as a Transaction
//		Payment payment=paymentDAL.getById(id);

//		if(payment==null)
//		{
//			throw new NotFoundException("No payment found with id:  "+id);
//		}
		
		paymentDAL.delete(id);
	}
}

