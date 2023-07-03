package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

//    Collection<Payment> getPaymentsByContractNumberId(Integer contractNumberId);

    Collection<Payment> getPaymentsByAmount(Integer amount);


}
