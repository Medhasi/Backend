package com.verinite.payment.serviceimpl;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verinite.payment.entity.PaymentEntity;
import com.verinite.payment.repository.PaymentRepo;


@Service
public class PaymentImpl  {
	
	
	@Autowired
	PaymentRepo repo;

//	@Override
//	public PaymentEntity savePayment(PaymentEntity payment) {
//		
//		return repo.save(payment);
//	}
//
	public List<PaymentEntity> getAllPaymentList() {
		
		return repo.findAll();
	}
	public PaymentEntity savePayment(PaymentEntity payment)
    {
    	payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString())  ;
        return repo.save(payment);
    }
    public String paymentProcessing()
    {
    	return "success";
    }
	public List<PaymentEntity> getAllPaymentListByuser(String username) {
		return repo.findByUsername(username);
	}
	}

