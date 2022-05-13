package com.verinite.payment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verinite.payment.entity.PaymentEntity;



@Repository
public interface PaymentRepo extends JpaRepository<PaymentEntity, Integer> {

	List<PaymentEntity> findByUsername(String username);

}
