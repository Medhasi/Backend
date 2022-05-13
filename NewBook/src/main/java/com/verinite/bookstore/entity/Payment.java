package com.verinite.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

@Entity
@Table(name="payment")
public class Payment {
	public Payment()
	{
	
	}

	public Payment(int i, String string, String string2, String string3, String string4, double d, String string5,
			String string6) {
		paymentId=i;
		accountNumber=string;
		customerName=string2;
		ifsc=string3;
		username=string4;
		amount=d;
		paymentStatus=string5;
		transactionId=string6;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="payment_id")
	private int paymentId;
	
	@Column(name="account_number")
	private String accountNumber;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="ifsc")
	private String ifsc;
	
	private String username;
	
	@Column(name="amount")
	private double amount;
	
	
	private String paymentStatus;
	
    private String transactionId;

	
}
