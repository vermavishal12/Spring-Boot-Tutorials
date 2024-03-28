package com.cn.cnpayment.service;

import com.cn.cnpayment.dal.OrderDal;
import com.cn.cnpayment.dal.PaymentDAL;
import com.cn.cnpayment.entity.Orders;
import com.cn.cnpayment.entity.Payment;
import com.cn.cnpayment.exception.ElementAlreadyExistException;
import com.cn.cnpayment.exception.NotFoundException;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
    Complete the OrderService class as mentioned below:

    a. Autowire OrderDal

    b. Complete the following methods:

      1. getOrderById(int id): This method fetches an Order for a specific Id.

      2. getAllOrders(): This method fetches the list of Orders.

      3. saveOrder(Orders newOrder): This method saves an Order.

      4. delete(int id): This method deletes an Order for a specific Id.
**/

@Service
public class OrderService {

    // Autowire the OrderDal object.
	@Autowired
	OrderDal orderDal;
	
	@Autowired
	PaymentDAL paymentDal;

    /**
     1. Complete the method body for getOrderById() by adding proper arguments.
     2. add proper annotation for registering this method as a Transaction
     **/
	@Transactional
    public Orders getOrderById(int id) {
    	Orders order = orderDal.getById(id);
    	if(order == null) {
    		throw new NotFoundException("Can't found the Order with Id: "+id);
    	}
    	return order;
    }


    /**
     1. Complete the method body for getAllOrders().
     2. add proper annotation for registering this method as a Transaction
     **/
	@Transactional
    public List<Orders> getAllOrders() {
    	List<Orders> allOrders = orderDal.getAllOrders();
    	if(allOrders == null) {
    		throw new NotFoundException("No order exist in the database");
    	}
    	return allOrders;
    }


    /**
     1. Complete the method body for saveOrder() method by adding proper arguments.
     2. add proper annotation for registering this method as a Transaction
     **/
	@Transactional
    public void saveOrder(Orders newOrder) {
		Orders order = orderDal.getById(newOrder.getId());
		if(order != null) {
			throw new ElementAlreadyExistException("Record with id " + newOrder.getId() + " Already exist in the database");
		}
		
		Orders saveOrder = new Orders();
		List<Payment>payments = newOrder.getPayments();
		List<Payment>paymentList = new ArrayList<> ();
		for(Payment payment: payments) {
			Payment p = paymentDal.getById(payment.getId());
			if(p != null) {
				paymentList.add(p);				
			}

		}
		
		saveOrder.setPayments(paymentList);
		saveOrder.setAmount(newOrder.getAmount());
		saveOrder.setCategory(newOrder.getCategory());
		saveOrder.setName(newOrder.getName());
		saveOrder.setQuantity(newOrder.getQuantity());
		orderDal.save(saveOrder);
		
    }


    /**
     1. Complete the method body for delete() method by adding proper arguments.
     2. add proper annotation for registering this method as a Transaction
     **/
	@Transactional
    public void delete(int id) {
//		Orders order = orderDal.getById(id);
//		if(order == null) {
//    		throw new NotFoundException("Can't found the Order with Id: "+id);
//    	}
		orderDal.delete(id);
    }


}
