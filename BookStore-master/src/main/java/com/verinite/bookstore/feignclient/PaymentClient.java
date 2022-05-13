package com.verinite.bookstore.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.verinite.bookstore.entity.Payment;

@FeignClient(url="http://localhost:8081/payment",name="paymentClient")
public interface PaymentClient {
	@GetMapping("/allList")
	public List<Payment> getAllPayment();
	@PostMapping("/save")
	public Payment savePayment(Payment payment);

}
