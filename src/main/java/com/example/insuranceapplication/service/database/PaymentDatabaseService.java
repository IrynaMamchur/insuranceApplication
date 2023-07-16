package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.payment.Payment;
import com.example.insuranceapplication.entity.updateDto.PaymentUpdateDto;

import java.util.List;
import java.util.Optional;

public interface PaymentDatabaseService {

    List<Payment> getPaymentsByAmount(Integer amount);

    List<Payment> getAllPayments();

    Optional<Payment> getPaymentById(Integer id);

    Payment create(Payment payment);

    void delete(Integer id);

    Optional<Payment> updateWithCheck(Integer id, PaymentUpdateDto paymentUpdateDto);

}
