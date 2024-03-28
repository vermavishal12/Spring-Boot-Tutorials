package com.cn.cnpayment.dal;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.cn.cnpayment.entity.PaymentDetails;
import com.cn.cnpayment.exception.NotFoundException;

import jakarta.persistence.EntityManager;

/**
 # Complete the PaymentDetailsDALImpl class as mentioned below:

 	a. Autowire EntityManager.

 	b. Override the following methods:

 		1. getById(int id): This method fetches PaymentDetails for a specific id from the database.

	 	2. getAllPaymentDetails(): This method fetches the list of PaymentDetails from the database.

	 	3. save(PaymentDetails paymentDetails): This method saves the PaymentDetails entity into the database.

	 	4. delete(int id): This method deletes the PaymentDetails entity for a specific id.

	 	5. update(PaymentDetails paymentDetails): This method updates paymentDetails.

	 	6. getByCurrency(String currency): This method fetches the list of PaymentDetails from the database for
                                           a specific currency.
 **/


@Repository
public class PaymentDetailsDALImpl implements PaymentDetailsDAL {
	
	@Autowired
	EntityManager entityManager;
	
	@Override
	public PaymentDetails getById(int id) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		PaymentDetails paymentDetails = session.get(PaymentDetails.class, id);
		return paymentDetails;
	}

	@Override
	public void save(PaymentDetails paymentDetails) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		session.save(paymentDetails);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		PaymentDetails currentPaymentDetails = session.get(PaymentDetails.class, id);
		session.delete(currentPaymentDetails);
		
	}

	@Override
	public List<PaymentDetails> getAllPaymentDetails() {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		List<PaymentDetails> allPaymentDetails = session.createQuery(
				"Select p from PaymentDetails p", PaymentDetails.class).getResultList();
		return allPaymentDetails;
	}

	@Override
	public void update(PaymentDetails paymentDetails) {
		// TODO Auto-generated method stub
		PaymentDetails currentPaymentDetails = getById(paymentDetails.getId());
		if(paymentDetails != null) {
			currentPaymentDetails.setAmount(paymentDetails.getAmount());
			currentPaymentDetails.setCreditAccount(paymentDetails.getCreditAccount());
			currentPaymentDetails.setCurrency(paymentDetails.getCurrency());
			currentPaymentDetails.setDebitAccount(paymentDetails.getDebitAccount());
			currentPaymentDetails.setPayment(paymentDetails.getPayment());
			Session session = entityManager.unwrap(Session.class);
			session.update(currentPaymentDetails);
		} 
		else {
			throw new NotFoundException("PaymentDetails could not be found");
		}
		
		
	}

	@Override
	public List<PaymentDetails> getByCurrency(String currency) {
		// TODO Auto-generated method stub
		List<PaymentDetails> allPaymentDetails = getAllPaymentDetails();
		List<PaymentDetails> reqPaymentDetails = new ArrayList<> ();
		for(PaymentDetails paymentDetails : allPaymentDetails) {
			if(paymentDetails.getCurrency().equalsIgnoreCase(currency)) {
				reqPaymentDetails.add(paymentDetails);
			}
		}
		
		return reqPaymentDetails;
	}

	// Auto-wire the EntityManager object


}
