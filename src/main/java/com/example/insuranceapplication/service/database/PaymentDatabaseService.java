package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.Payment;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PaymentDatabaseService {

    List<Payment> getPaymentsByAmount(Integer amount);

    List<Payment> getAllPayments();

    Optional<Payment> getPaymentById(Integer id);

    Payment create(Payment payment);

    Payment update(Payment payment);
//
//    Integer getPaymentId (@Param("id") Integer id);
}
