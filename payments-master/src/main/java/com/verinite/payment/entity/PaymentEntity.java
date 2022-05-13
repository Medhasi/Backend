package com.verinite.payment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "payments")
public class PaymentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int	paymentId;
	private String accountNumber;
	private String customerName;
	private String ifsc;
	private String username;
	private String paymentStatus;
    private String transactionId;
    private int orderId;
    private double amount;

}
