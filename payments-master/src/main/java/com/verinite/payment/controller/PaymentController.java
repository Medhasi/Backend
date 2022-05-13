package com.verinite.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verinite.payment.entity.PaymentEntity;

import com.verinite.payment.serviceimpl.PaymentImpl;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "http://192.168.137.1:4200")

public class PaymentController {
	@Autowired
	PaymentImpl service;
	
	@GetMapping("/allList")
	List<PaymentEntity> getPaymentList()
	{
		return service.getAllPaymentList();
	}
	@GetMapping("/allList/{username}")
	List<PaymentEntity> getPaymentListbyUsername(@PathVariable String username)
	{
		return service.getAllPaymentListByuser(username);
	}
	
	@PostMapping("/save")
	PaymentEntity savePayment(@RequestBody PaymentEntity payment)
	{
		return service.savePayment(payment);
	}

}
