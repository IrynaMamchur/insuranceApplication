package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    /**
     * Finds an Payment entity from database by amount of insurance payment
     * @param amount The amount of the Payment
     * @return Payment entity from database that was found by amount of insurance payment
     */
    Collection<Payment> getPaymentsByAmount(Double amount);

}
