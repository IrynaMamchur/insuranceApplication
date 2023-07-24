package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.car.CarInsuranceProgram;
import com.example.insuranceapplication.repository.carRepository.CarInsuranceProgramRepository;
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
class CarInsuranceProgramDatabaseServiceImplTest {

    @Mock
    private CarInsuranceProgramRepository carInsuranceProgramRepository;
    private CarInsuranceProgramDatabaseServiceImpl underTest;

    @InjectMocks
   CarInsuranceProgramDatabaseServiceImpl carInsuranceProgramDatabaseService;

    @BeforeEach
    void setup() {
        underTest= new CarInsuranceProgramDatabaseServiceImpl(carInsuranceProgramRepository); }


    @Test
    void getInsuranceProgramByName() {
        underTest.getInsuranceProgramByName("KASKO");
        verify(carInsuranceProgramRepository).getInsuranceProgramByInsuranceProgramName("KASKO");
    }

    @Test
    void getInsuranceProgramByName_nullReturned() {
        underTest.getInsuranceProgramByName(null);
        verify(carInsuranceProgramRepository).getInsuranceProgramByInsuranceProgramName(isNull());
    }

    @Test
    void getInsuranceProgramById() {
        underTest.getInsuranceProgramById(1);
        verify(carInsuranceProgramRepository).findById(1);
    }
    @Test
    void getInsuranceProgramById_nullReturn() {
        underTest.getInsuranceProgramById(null);
        verify(carInsuranceProgramRepository).findById(isNull());
    }


    @Test
    void getAllInsuranceProgram() {
        underTest.getAllInsuranceProgram();
        verify(carInsuranceProgramRepository).findAll();
    }

    @Test
    void getAllInsuranceProgram_emptyListReturn() {
        underTest.getAllInsuranceProgram().isEmpty();
        assertTrue((carInsuranceProgramRepository).findAll().isEmpty());
    }



    @Test
    void create() {
        CarInsuranceProgram carInsuranceProgram = new CarInsuranceProgram();
        underTest.create(carInsuranceProgram);
        ArgumentCaptor<CarInsuranceProgram> carInsuranceProgramArgumentCaptor = ArgumentCaptor.forClass(CarInsuranceProgram.class);
        verify(carInsuranceProgramRepository).save(carInsuranceProgramArgumentCaptor.capture());
        CarInsuranceProgram capturedCarInsuranceProgram = carInsuranceProgramArgumentCaptor.getValue();
        assertEquals(capturedCarInsuranceProgram, carInsuranceProgram);

    }

    @Test
    void create_null() {
        CarInsuranceProgram carInsuranceProgram = new CarInsuranceProgram();
        boolean b = underTest.create(carInsuranceProgram)==null;
        ArgumentCaptor<CarInsuranceProgram> carInsuranceProgramArgumentCaptor = ArgumentCaptor.forClass(CarInsuranceProgram.class);
        verify(carInsuranceProgramRepository).save(carInsuranceProgramArgumentCaptor.capture());
        CarInsuranceProgram capturedCarInsuranceProgram = carInsuranceProgramArgumentCaptor.getValue();
        assertEquals(capturedCarInsuranceProgram, carInsuranceProgram);
    }


    @Test
    void getCoefficientCarInsuranceProgram() {
        underTest.getCoefficientCarInsuranceProgram("KASKO");
        verify(carInsuranceProgramRepository).getCoefficientCarInsuranceProgram("KASKO");
    }

    @Test
    void getCoefficientCarInsuranceProgram_nullReturned() {
        underTest.getCoefficientCarInsuranceProgram(null);
        verify(carInsuranceProgramRepository).getCoefficientCarInsuranceProgram(isNull());
    }


    @Test
    void delete() {
        underTest.delete(1);
        verify(carInsuranceProgramRepository).deleteById(1);
    }

    @Test
    void delete_null() {
        underTest.delete(null);
        verify(carInsuranceProgramRepository).deleteById(isNull());
    }

    @Test
    void updateWithCheck() {
    }
}