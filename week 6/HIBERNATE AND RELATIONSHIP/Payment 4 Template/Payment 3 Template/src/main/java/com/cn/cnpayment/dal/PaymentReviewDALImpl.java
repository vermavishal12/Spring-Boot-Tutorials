package com.cn.cnpayment.dal;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnpayment.entity.PaymentReview;
import com.cn.cnpayment.exception.InvalidInputException;

import jakarta.persistence.EntityManager;



@Repository
public class PaymentReviewDALImpl implements PaymentReviewDAL {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public PaymentReview getById(int id) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		PaymentReview paymentReview = session.get(PaymentReview.class, id);
		return paymentReview;
	}

	@Override
	public void save(PaymentReview paymentDetails) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		session.save(paymentDetails);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		PaymentReview paymentReview = getById(id);
		session.delete(paymentReview);
	}

	@Override
	public List<PaymentReview> getAllPaymentReview() {
		// TODO Auto-generated method stub
		System.out.println("DAL Layer.....");
		Session session = entityManager.unwrap(Session.class);
		List<PaymentReview> allPaymentReviews = session.createQuery(
				"Select p from PaymentReview p", PaymentReview.class).getResultList();
		return allPaymentReviews;
	}

	@Override
	public List<PaymentReview> getByQueryType(String queryType) {
		// TODO Auto-generated method stub
		System.out.println("DAL Layer.....");
		boolean isValid = false;
		if(queryType.equalsIgnoreCase("Payment Issue")) {
			isValid = true;
		}
		if(queryType.equalsIgnoreCase("Bank Issue")) {
			isValid = true;
		}
		if(queryType.equalsIgnoreCase("Merchant Issue")) {
			isValid = true;
		}
		
		if(!isValid) {
			throw new InvalidInputException("Query type is not valid!!");
		}
		Session session = entityManager.unwrap(Session.class);
		List<PaymentReview> allPaymentReviews = session.createQuery(
				"Select p from PaymentReview p", PaymentReview.class).getResultList();
		
		List<PaymentReview> reqPaymentReview = new ArrayList<> ();
		for(PaymentReview paymentReview : allPaymentReviews) {
			if(paymentReview.getQueryType().equalsIgnoreCase(queryType)) {
				reqPaymentReview.add(paymentReview);
			}
		}
		
		return reqPaymentReview;
	}

/**

 Complete the PaymentReviewDALImpl implementation class as mentioned below:

 	a. Autowire EntityManager.

 	b. Override the following methods:

 		1. getById(int id): This method fetches PaymentReview for a specific id.

 		2. getAllPaymentReview(): This method fetches the list of all PaymentReview from the database.

 		3. save(PaymentReview paymentReview): This method saves the PaymentReview entity into the database.

 		4. delete(int id): This method deletes the PaymentReview entity from the database for a specific id.

 		5. getByQueryType(String queryType): This method fetches the list of PaymentReview based on the
                                             queryType received.

 **/

}
