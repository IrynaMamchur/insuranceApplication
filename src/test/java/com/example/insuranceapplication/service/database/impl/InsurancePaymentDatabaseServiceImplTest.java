package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.InsurancePayment;
import com.example.insuranceapplication.repository.InsurancePaymentRepository;
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
class InsurancePaymentDatabaseServiceImplTest {
@Mock
private InsurancePaymentRepository insurancePaymentRepository;
private InsurancePaymentDatabaseServiceImpl underTest;
private CoefficientDatabaseServiceImpl coefficientDatabaseService;

@InjectMocks
InsurancePaymentDatabaseServiceImpl insurancePaymentDatabaseService;

@BeforeEach
void setup(){
    underTest = new InsurancePaymentDatabaseServiceImpl(insurancePaymentRepository, coefficientDatabaseService);
}
    @Test
    void create() {
        InsurancePayment insurancePayment = new InsurancePayment();
        underTest.create(insurancePayment);
        ArgumentCaptor<InsurancePayment>insurancePaymentArgumentCaptor = ArgumentCaptor.forClass(InsurancePayment.class);
        verify(insurancePaymentRepository).save(insurancePaymentArgumentCaptor.capture());
        InsurancePayment captureInsurancePayment = insurancePaymentArgumentCaptor.getValue();
        assertEquals(captureInsurancePayment, insurancePayment);
    }
    @Test
    void create_null() {
        InsurancePayment insurancePayment = new InsurancePayment();
        boolean b = underTest.create(insurancePayment)==null;
        ArgumentCaptor<InsurancePayment>insurancePaymentArgumentCaptor = ArgumentCaptor.forClass(InsurancePayment.class);
        verify(insurancePaymentRepository).save(insurancePaymentArgumentCaptor.capture());
        InsurancePayment captureInsurancePayment = insurancePaymentArgumentCaptor.getValue();
        assertEquals(captureInsurancePayment, insurancePayment);
    }


    @Test
    void createInsurancePayment() {
    }

    @Test
    void getAmount() {
    underTest.getAmount(1);
    verify(insurancePaymentRepository).getAmount(1);
    }

    @Test
    void getAmount_nullReturned() {
        underTest.getAmount(null);
        verify(insurancePaymentRepository).getAmount(isNull());
    }

    @Test
    void updateInsurancePayment() {
    }

    @Test
    void delete() {
    underTest.delete(1);
    verify(insurancePaymentRepository).deleteById(1);
    }

    @Test
    void delete_null() {
        underTest.delete(null);
        verify(insurancePaymentRepository).deleteById(isNull());
    }

    @Test
    void updateWithCheck() {
    }

    @Test
    void getInsurancePaymentById() {
    underTest.getInsurancePaymentById(1);
    verify(insurancePaymentRepository).findById(1);
    }

    @Test
    void getInsurancePaymentById_nullReturned() {
        underTest.getInsurancePaymentById(null);
        verify(insurancePaymentRepository).findById(isNull());
    }

}