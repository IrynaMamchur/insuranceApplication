package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.Payment;
import com.example.insuranceapplication.repository.PaymentRepository;
import com.example.insuranceapplication.service.database.PaymentDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentDatabaseServiceImpl implements PaymentDatabaseService {
    private final PaymentRepository paymentRepository;


    @Override
    public List<Payment> getPaymentsByContractNumberId(Integer contractNumberId) {
        return (List<Payment>) paymentRepository.getPaymentsByContractNumberId(contractNumberId);
    }

    @Override
    public List<Payment> getPaymentsByAmount(Integer amount) {
        return (List<Payment>) paymentRepository.getPaymentsByAmount(amount);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> getPaymentById(Integer id) {
        return paymentRepository.findById(id);
    }

    @Override
    public Payment create(Payment payment) {
        return paymentRepository.save(new Payment());
    }

    @Override
    public Payment update(Payment payment) {
        return paymentRepository.save(payment);
    }
}
