package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.payment.PaymentDetail;
import com.example.insuranceapplication.repository.PaymentDetailRepository;
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
class PaymentDetailDatabaseServiceImplTest {

    @Mock
    private PaymentDetailRepository paymentDetailRepository;
    private PaymentDetailDatabaseServiceImpl underTest;

    @InjectMocks
    PaymentDetailDatabaseServiceImpl paymentDetailDatabaseService;

    @BeforeEach
    void setup(){
        underTest = new PaymentDetailDatabaseServiceImpl(paymentDetailRepository);
    }

    @Test
    void getAllPaymentDetails() {
        underTest.getAllPaymentDetails();
        verify(paymentDetailRepository).findAll();
    }

    @Test
    void getAllPaymentDetails_emptyListReturn() {
        underTest.getAllPaymentDetails().isEmpty();
        assertTrue((paymentDetailRepository).findAll().isEmpty());
    }

    @Test
    void getPaymentDetailById() {
        underTest.getPaymentDetailById(1);
        verify(paymentDetailRepository).findById(1);
    }

    @Test
    void getPaymentDetailById_nullReturned() {
        underTest.getPaymentDetailById(null);
        verify(paymentDetailRepository).findById(isNull());
    }

    @Test
    void create() {
        PaymentDetail paymentDetail = new PaymentDetail();
        underTest.create(paymentDetail);
        ArgumentCaptor<PaymentDetail>paymentDetailArgumentCaptor = ArgumentCaptor.forClass(PaymentDetail.class);
        verify(paymentDetailRepository).save(paymentDetailArgumentCaptor.capture());
        PaymentDetail capturePaymentDetail = paymentDetailArgumentCaptor.getValue();
        assertEquals(capturePaymentDetail, paymentDetail);
    }

    @Test
    void create_null() {
        PaymentDetail paymentDetail = new PaymentDetail();
        boolean b= underTest.create(paymentDetail)== null;
        ArgumentCaptor<PaymentDetail>paymentDetailArgumentCaptor = ArgumentCaptor.forClass(PaymentDetail.class);
        verify(paymentDetailRepository).save(paymentDetailArgumentCaptor.capture());
        PaymentDetail capturePaymentDetail = paymentDetailArgumentCaptor.getValue();
        assertEquals(capturePaymentDetail, paymentDetail);
    }


    @Test
    void delete() {
        underTest.delete(1);
        verify(paymentDetailRepository).deleteById(1);
    }

    @Test
    void delete_null() {
        underTest.delete(null);
        verify(paymentDetailRepository).deleteById(isNull());
    }

    @Test
    void updateWithCheck() {
    }
}