package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.car.CarQuantityOfPayments;
import com.example.insuranceapplication.repository.carRepository.CarQuantityOfPaymentsRepository;
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
class CarQuantityOfPaymentsDatabaseServiceImplTest {

    @Mock
    private CarQuantityOfPaymentsRepository carQuantityOfPaymentsRepository;
    private CarQuantityOfPaymentsDatabaseServiceImpl underTest;


    @InjectMocks
    CarQuantityOfPaymentsDatabaseServiceImpl carQuantityOfPaymentsDatabaseService;

    @BeforeEach
    void setup() {
        underTest = new CarQuantityOfPaymentsDatabaseServiceImpl(carQuantityOfPaymentsRepository);
    }


    @Test
    void create_success() {
        CarQuantityOfPayments carQuantityOfPayments = new CarQuantityOfPayments();
        underTest.create(carQuantityOfPayments);
        ArgumentCaptor<CarQuantityOfPayments> carQuantityOfPaymentsArgumentCaptor = ArgumentCaptor.forClass(CarQuantityOfPayments.class);
        verify(carQuantityOfPaymentsRepository).save(carQuantityOfPaymentsArgumentCaptor.capture());
        CarQuantityOfPayments capturedCarQuantityOfPayments = carQuantityOfPaymentsArgumentCaptor.getValue();
        assertEquals(capturedCarQuantityOfPayments, carQuantityOfPayments);
    }

    @Test
    void create_null() {
        CarQuantityOfPayments carQuantityOfPayments = new CarQuantityOfPayments();
        boolean b = underTest.create(carQuantityOfPayments) == null;
        ArgumentCaptor<CarQuantityOfPayments> carQuantityOfPaymentsArgumentCaptor = ArgumentCaptor.forClass(CarQuantityOfPayments.class);
        verify(carQuantityOfPaymentsRepository).save(carQuantityOfPaymentsArgumentCaptor.capture());
        CarQuantityOfPayments capturedCarQuantityOfPayments = carQuantityOfPaymentsArgumentCaptor.getValue();
        assertEquals(capturedCarQuantityOfPayments, carQuantityOfPayments);
    }

    @Test
    void getAllCarQuantityOfPayments() {
        underTest.getAllCarQuantityOfPayments();
        verify(carQuantityOfPaymentsRepository).findAll();
    }

    @Test
    void getAllCarQuantityOfPayments_emptyListReturn() {
        underTest.getAllCarQuantityOfPayments().isEmpty();
        assertTrue((carQuantityOfPaymentsRepository).findAll().isEmpty());
    }


    @Test
    void getCoefficientCarNumberOfPayments() {
        underTest.getCoefficientCarNumberOfPayments(1);
        verify(carQuantityOfPaymentsRepository).getCoefficientCarNumberOfPayments(1);
    }

    @Test
    void getCoefficientCarNumberOfPayments_nullReturned() {
        underTest.getCoefficientCarNumberOfPayments(null);
        verify(carQuantityOfPaymentsRepository).getCoefficientCarNumberOfPayments(isNull());
    }

    @Test
    void delete() {
        underTest.delete(1);
        verify(carQuantityOfPaymentsRepository).deleteById(1);
    }

    @Test
    void delete_null() {
        underTest.delete(null);
        verify(carQuantityOfPaymentsRepository).deleteById(isNull());
    }

    @Test
    void updateWithCheck() {
    }

    @Test
    void getCarQuantityOfPaymentsByID() {
        underTest.getCarQuantityOfPaymentsByID(1);
        verify(carQuantityOfPaymentsRepository).findById(1);
    }

    @Test
    void getCarQuantityOfPaymentsByID_nullReturn() {
        underTest.getCarQuantityOfPaymentsByID(null);
        verify(carQuantityOfPaymentsRepository).findById(isNull());
    }


}