package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.payment.Payment;
import com.example.insuranceapplication.entity.updateDto.PaymentUpdateDto;
import com.example.insuranceapplication.repository.PaymentRepository;
import com.example.insuranceapplication.service.database.PaymentDatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentDatabaseServiceImpl implements PaymentDatabaseService {
    private final PaymentRepository paymentRepository;

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

    @Override
    public void delete(Integer id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public Optional<Payment> updateWithCheck(Integer id, PaymentUpdateDto paymentUpdateDto) {
        Optional<Payment> paymentOptional = paymentRepository.findById(id);
        if (paymentOptional.isPresent() && paymentUpdateDto != null) {
            Payment payment = paymentOptional.get();
            if (paymentUpdateDto.getDateOfPayment() != null) {
                payment.setDateOfPayment(paymentUpdateDto.getDateOfPayment());
            }
            if (paymentUpdateDto.getAmount() != null) {
                payment.setAmount(paymentUpdateDto.getAmount());
            }
            paymentRepository.save(payment);
            return Optional.of(payment);
        }
        return Optional.empty();
    }
}

