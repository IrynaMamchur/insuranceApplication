package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.Coefficient;
import com.example.insuranceapplication.repository.CoefficientRepository;
import com.example.insuranceapplication.service.database.*;
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
class CoefficientDatabaseServiceImplTest {
@Mock
private CoefficientRepository coefficientRepository;
    private CarBrandDatabaseService carBrandDatabaseService;
    private CarEngineCapacityDatabaseService carEngineCapacityDatabaseService;
    private CarInsuranceProgramDatabaseService carInsuranceProgramDatabaseService;
    private CarYearOfIssueDatabaseService carYearOfIssueDatabaseService;
    private CarQuantityOfPaymentsDatabaseService carQuantityOfPaymentsDatabaseService;


    private CoefficientDatabaseServiceImpl underTest;

@InjectMocks
CoefficientDatabaseServiceImpl coefficientDatabaseService;


@BeforeEach
void setup() {
    underTest = new CoefficientDatabaseServiceImpl(coefficientRepository, carBrandDatabaseService, carEngineCapacityDatabaseService,carInsuranceProgramDatabaseService, carYearOfIssueDatabaseService, carQuantityOfPaymentsDatabaseService);
}

    @Test
    void createCoefficient() {
    }


    @Test
    void getCoefficientCoefficient() {
    underTest.getCoefficientCoefficient(1);
    verify(coefficientRepository).getCoefficient(1);
    }

    @Test
    void getCoefficientCoefficient_nullReturned() {
        underTest.getCoefficientCoefficient(null);
        verify(coefficientRepository).getCoefficient(isNull());
    }

    @Test
    void create() {
        Coefficient coefficient = new Coefficient();
        underTest.create(coefficient);
        ArgumentCaptor<Coefficient>coefficientArgumentCaptor = ArgumentCaptor.forClass(Coefficient.class);
        verify(coefficientRepository).save(coefficientArgumentCaptor.capture());
        Coefficient captureCoefficient = coefficientArgumentCaptor.getValue();
        assertEquals(captureCoefficient, coefficient);

    }

    @Test
    void create_null() {
        Coefficient coefficient = new Coefficient();
        boolean b =  underTest.create(coefficient)==null;
        ArgumentCaptor<Coefficient>coefficientArgumentCaptor = ArgumentCaptor.forClass(Coefficient.class);
        verify(coefficientRepository).save(coefficientArgumentCaptor.capture());
        Coefficient captureCoefficient = coefficientArgumentCaptor.getValue();
        assertEquals(captureCoefficient, coefficient);

    }

    @Test
    void updateCoefficientForCar() {
    }

    @Test
    void delete() {
    underTest.delete(1);
    verify(coefficientRepository).deleteById(1);
    }

    @Test
    void delete_null() {
        underTest.delete(null);
        verify(coefficientRepository).deleteById(isNull());
    }

    @Test
    void updateWithCheck() {
    }

    @Test
    void getCoefficientById() {
    underTest.getCoefficientById(1);
    verify(coefficientRepository).findById(1);
    }

    @Test
    void getCoefficientById_nullReturned() {
        underTest.getCoefficientById(null);
        verify(coefficientRepository).findById(isNull());
    }


}