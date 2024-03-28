package com.cn.cnpayment.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name="Payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;

	@Column
	private String paymentType;

	@Column
	private String description;

	// Add proper annotation for establishing one-to-one relationship with PaymentDetails.
	@JsonManagedReference
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private PaymentDetails paymentDetails;


	@JsonManagedReference
	@OneToMany(fetch = FetchType.EAGER,mappedBy= "payment", cascade = CascadeType.ALL)
	private List<PaymentReview> paymentReviews;
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.EAGER,mappedBy="payments")
	private List<Orders> orders;

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
	public List<PaymentReview> getPaymentReviews() {
		return paymentReviews;
	}

	public void setPaymentReviews(List<PaymentReview> paymentReviews) {
		this.paymentReviews = paymentReviews;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	public Payment() {
	}

	public Payment(int id, String paymentType, String description) {
		this.id = id;
		this.paymentType = paymentType;
		this.description = description;
	}

	public Payment(int id, String paymentType, String description, PaymentDetails paymentDetails) {
		this.id = id;
		this.paymentType = paymentType;
		this.description = description;
		this.paymentDetails = paymentDetails;
	}
	
	public Payment(int id, String paymentType, String description,PaymentDetails paymentDetails, List<PaymentReview> paymentReviews) {
		this.id = id;
		this.paymentType = paymentType;
		this.description = description;
		this.paymentDetails = paymentDetails;
		this.paymentReviews = paymentReviews;
	}
	
	public Payment(int id, String paymentType, String description, PaymentDetails paymentDetails,
			List<PaymentReview> paymentReviews, List<Orders> orders) {
		this.id = id;
		this.paymentType = paymentType;
		this.description = description;
		this.paymentDetails = paymentDetails;
		this.paymentReviews = paymentReviews;
		this.orders = orders;
	}

	
}
