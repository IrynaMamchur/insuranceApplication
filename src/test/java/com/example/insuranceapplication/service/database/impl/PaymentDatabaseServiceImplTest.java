package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.payment.Payment;
import com.example.insuranceapplication.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PaymentDatabaseServiceImplTest {
@Mock
private PaymentRepository paymentRepository;
private PaymentDatabaseServiceImpl underTest;

@InjectMocks
PaymentDatabaseServiceImpl paymentDatabaseService;

@BeforeEach
void setup(){
    underTest = new PaymentDatabaseServiceImpl(paymentRepository);
}

    @Test
    void getPaymentsByAmount() {
    underTest.getPaymentsByAmount(2000.0);
    verify(paymentRepository).getPaymentsByAmount(2000.0);
    }

    @Test
    void getPaymentsByAmount_nullReturned() {
        underTest.getPaymentsByAmount(null);
        verify(paymentRepository).getPaymentsByAmount(isNull());
    }

    @Test
    void getAllPayments() {
    underTest.getAllPayments();
    verify(paymentRepository).findAll();
    }

    @Test
    void getAllPayments_emptyListReturn() {
        underTest.getAllPayments().isEmpty();
        assertTrue((paymentRepository).findAll().isEmpty());
    }

    @Test
    void getPaymentById() {
    underTest.getPaymentById(1);
    verify(paymentRepository).findById(1);
    }

    @Test
    void getPaymentById_nullReturned() {
        underTest.getPaymentById(null);
        verify(paymentRepository).findById(isNull());
    }

    @Test
    void create() {
        Payment payment = new Payment();
        underTest.create(payment);
        ArgumentCaptor<Payment> paymentArgumentCaptor = ArgumentCaptor.forClass(Payment.class);
        verify(paymentRepository).save(paymentArgumentCaptor.capture());
        Payment capturePayment = paymentArgumentCaptor.getValue();
        assertEquals(capturePayment, payment);
    }

    @Test
    void create_null() {
        Payment payment = new Payment();
        boolean b = underTest.create(payment)==null;
        ArgumentCaptor<Payment> paymentArgumentCaptor = ArgumentCaptor.forClass(Payment.class);
        verify(paymentRepository).save(paymentArgumentCaptor.capture());
        Payment capturePayment = paymentArgumentCaptor.getValue();
        assertEquals(capturePayment, payment);
    }


    @Test
    void delete() {
    underTest.delete(1);
    verify(paymentRepository).deleteById(1);
    }

    @Test
    void delete_null() {
        underTest.delete(null);
        verify(paymentRepository).deleteById(isNull());
    }

    @Test
    void updateWithCheck() {
    }
}