package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentDatabaseService {

    List<Payment> getPaymentsByContractNumberId(Integer contractNumberId);

    List<Payment> getPaymentsByAmount (Integer amount);

    List<Payment> getAllPayments();

    Optional<Payment> getPaymentById(Integer id);

    Payment create(Payment payment);

    Payment update(Payment payment);
}
