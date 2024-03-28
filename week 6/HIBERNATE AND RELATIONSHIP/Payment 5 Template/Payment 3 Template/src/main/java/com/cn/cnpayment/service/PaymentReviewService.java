package com.cn.cnpayment.service;

import com.cn.cnpayment.exception.InvalidInputException;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnpayment.dal.PaymentReviewDAL;
import com.cn.cnpayment.entity.PaymentReview;
import com.cn.cnpayment.exception.ElementAlreadyExistException;
import com.cn.cnpayment.exception.NotFoundException;


import java.util.List;

@Service
public class PaymentReviewService {

	// Autowire the PaymentReviewDAL object.

	@Autowired
	PaymentReviewDAL paymentReviewDAL;
	
	@Transactional
	public PaymentReview getPaymentReviewById(int id) {
		/**
		   1. This method fetches PaymentReview for a specific id.
		   2. If no paymentReview is found then it throws NotFoundException.
		**/
		PaymentReview paymentReview = paymentReviewDAL.getById(id);
		if(paymentReview == null) {
			throw new NotFoundException("The payment review with id "+id+" cannot be found");
		}
		return paymentReview;
	}

	@Transactional
	public List<PaymentReview> getAllPaymentReviews() {
		/**
		 1. This method fetches the list of all PaymentReviews.
		 2. If no paymentReview is found then it throws NotFoundException.
		 **/
		List<PaymentReview> allPaymentReviews = paymentReviewDAL.getAllPaymentReview();
		if(allPaymentReviews == null) {
			throw new NotFoundException("No reviews exist in the database");
		}
		return allPaymentReviews;
	}

	@Transactional
	public void savePaymentReview(PaymentReview newPaymentReview) {
		/**
		 1. This method first checks if the given paymentReview exists or not.
		 2. If the given paymentReview is not found, then it saves the PaymentReview entity into the database.
		 3. If found then it throws ElementAlreadyExistException.
		 **/
		
		PaymentReview paymentReview = paymentReviewDAL.getById(newPaymentReview.getId());
		if(paymentReview != null) {
			throw new ElementAlreadyExistException("The record with the Payment Review already exist in the database");
		}
		
		paymentReviewDAL.save(newPaymentReview);
	}

	@Transactional
	public void delete(int id) {
		/**
		 1. This method deletes PaymentReview for a specific id.
		 2. If no paymentReview is found for the given id, then it throws NotFoundException.
		 **/
		PaymentReview paymentReview = paymentReviewDAL.getById(id);
		if(paymentReview == null) {
			throw new NotFoundException("The Payment Review with id "+ id + " doesn't exist in the database");
		}
		System.out.println("reached the delete method");
		paymentReviewDAL.delete(id);
		System.out.println("deleted the method");
	}

	@Transactional
	public List<PaymentReview> getPaymentReviewByQueryType(String queryType) {
		/**
		 1. This method fetches the list of PaymentReview based on the queryType received.
		 2. Passing an empty queryType throws InvalidInputException.
		 3. Only the following queryType are accepted in any format i.e. UpperCase/LowerCase
		 "Payment Issue","Bank Issue", "Merchant Issue"
		 **/

		List<PaymentReview> paymentReviews = paymentReviewDAL.getByQueryType(queryType);
		if (paymentReviews.isEmpty()) {
			throw new InvalidInputException("Invalid Currency");
		}
		return paymentReviews;
	}

}
