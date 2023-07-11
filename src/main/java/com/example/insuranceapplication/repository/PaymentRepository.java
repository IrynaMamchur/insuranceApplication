package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    Collection<Payment> getPaymentsByAmount(Integer amount);

}
