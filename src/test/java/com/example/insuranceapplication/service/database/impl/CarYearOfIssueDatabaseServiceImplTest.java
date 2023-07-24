package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.car.CarYearOfIssue;
import com.example.insuranceapplication.repository.carRepository.CarYearOfIssueRepository;
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
class CarYearOfIssueDatabaseServiceImplTest {

    @Mock
    private CarYearOfIssueRepository carYearOfIssueRepository;
    private CarYearOfIssueDatabaseServiceImpl underTest;

    @InjectMocks
    CarYearOfIssueDatabaseServiceImpl carYearOfIssueDatabaseService;

    @BeforeEach
    void setup() {
        underTest = new CarYearOfIssueDatabaseServiceImpl(carYearOfIssueRepository);
    }

    @Test
    void getYearOfIssueByCarFirstRegistr() {
        underTest.getYearOfIssueByCarFirstRegistr(2020);
        verify(carYearOfIssueRepository).getYearOfIssueByCarFirstRegistr(2020);
    }

    @Test
    void getYearOfIssueByCarFirstRegistr_nullReturned() {
        underTest.getYearOfIssueByCarFirstRegistr(null);
        verify(carYearOfIssueRepository).getYearOfIssueByCarFirstRegistr(isNull());
    }


    @Test
    void getCarYearOfIssueById() {
        underTest.getCarYearOfIssueById(1);
        verify(carYearOfIssueRepository).findById(1);
    }

    @Test
    void getCarYearOfIssueById_nullReturn() {
        underTest.getCarYearOfIssueById(null);
        verify(carYearOfIssueRepository).findById(isNull());
    }


    @Test
    void getAllCarYearOfIssue() {
        underTest.getAllCarYearOfIssue();
        verify(carYearOfIssueRepository).findAll();
    }

    @Test
    void getAllCarYearOfIssue_emptyListReturn() {
        underTest.getAllCarYearOfIssue().isEmpty();
        assertTrue((carYearOfIssueRepository).findAll().isEmpty());
    }


    @Test
    void create_success() {
        CarYearOfIssue carYearOfIssue = new CarYearOfIssue();
        underTest.create(carYearOfIssue);
        ArgumentCaptor<CarYearOfIssue> carYearOfIssueArgumentCaptor = ArgumentCaptor.forClass(CarYearOfIssue.class);
        verify(carYearOfIssueRepository).save(carYearOfIssueArgumentCaptor.capture());
        CarYearOfIssue captureCarYearOfIssue = carYearOfIssueArgumentCaptor.getValue();
        assertEquals(captureCarYearOfIssue, carYearOfIssue);
    }

    @Test
    void create_null() {
        CarYearOfIssue carYearOfIssue = new CarYearOfIssue();
        boolean b = underTest.create(carYearOfIssue) == null;
        ArgumentCaptor<CarYearOfIssue> carYearOfIssueArgumentCaptor = ArgumentCaptor.forClass(CarYearOfIssue.class);
        verify(carYearOfIssueRepository).save(carYearOfIssueArgumentCaptor.capture());
        CarYearOfIssue captureCarYearOfIssue = carYearOfIssueArgumentCaptor.getValue();
        assertEquals(captureCarYearOfIssue, carYearOfIssue);
    }


    @Test
    void getCoefficientCarYearOfIssue_success() {
        underTest.getCoefficientCarYearOfIssue(2020);
        verify(carYearOfIssueRepository).getCoefficientCarYearOfIssue(2020);
    }

    @Test
    void getCoefficientCarYearOfIssue_nullReturned() {
        underTest.getCoefficientCarYearOfIssue(null);
        verify(carYearOfIssueRepository).getCoefficientCarYearOfIssue(isNull());
    }


    @Test
    void delete() {
        underTest.delete(1);
        verify(carYearOfIssueRepository).deleteById(1);
    }

    @Test
    void delete_null() {
        underTest.delete(null);
        verify(carYearOfIssueRepository).deleteById(isNull());
    }

    @Test
    void updateWithCheck() {
    }

}