package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.car.CarBrand;
import com.example.insuranceapplication.repository.carRepository.CarBrandRepository;
import com.example.insuranceapplication.repository.carRepository.CarEngineCapacityRepository;
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
class CarBrandDatabaseServiceImplTest {

    @Mock
    private CarBrandRepository carBrandRepository;
    private CarBrandDatabaseServiceImpl underTest;

    @InjectMocks
    CarBrandDatabaseServiceImpl carBrandDatabaseService;

    @BeforeEach
    void setup() {
        underTest= new CarBrandDatabaseServiceImpl(carBrandRepository); }


    @Test
    void getCarBrandByName() {
        underTest.getCarBrandByName("BMW");
        verify(carBrandRepository).getBrandByCarBrandName("BMW");
    }
    @Test
    void getCarBrandByName_nullReturned() {
        underTest.getCarBrandByName(null);
        verify(carBrandRepository).getBrandByCarBrandName(isNull());
    }


    @Test
    void getCarBrandById_success() {
        underTest.getCarBrandById(1);
        verify(carBrandRepository).findById(1);
    }

    @Test
    void getCarBrandById_nullReturned() {
        underTest.getCarBrandById(null);
        verify(carBrandRepository).findById(isNull());
    }


    @Test
    void getCarBrands() {
        underTest.getCarBrands();
        verify(carBrandRepository).findAll();
    }

    @Test
    void getCarBrands_emptyListReturn() {
        underTest.getCarBrands().isEmpty();
        assertTrue ((carBrandRepository).findAll().isEmpty());
    }

    @Test
    void create() {
        CarBrand carBrand = new CarBrand();
        underTest.create(carBrand);
        ArgumentCaptor<CarBrand> carBrandArgumentCaptor = ArgumentCaptor.forClass(CarBrand.class);
        verify(carBrandRepository).save(carBrandArgumentCaptor.capture());
        CarBrand capturedCarBrand = carBrandArgumentCaptor.getValue();
        assertEquals(capturedCarBrand, carBrand);
    }

    @Test
    void create_null() {
        CarBrand carBrand = new CarBrand();
        boolean b =underTest.create(carBrand) ==null;
        ArgumentCaptor<CarBrand> carBrandArgumentCaptor = ArgumentCaptor.forClass(CarBrand.class);
        verify(carBrandRepository).save(carBrandArgumentCaptor.capture());
        CarBrand capturedCarBrand = carBrandArgumentCaptor.getValue();
        assertEquals(capturedCarBrand, carBrand);
    }


    @Test
    void getCoefficientCarBrand_success() {
        underTest.getCoefficientCarBrand("BMW");
        verify(carBrandRepository).getCoefficientCarBrand("BMW");

    }

    @Test
    void getCoefficientCarBrand_nullReturned() {
        underTest.getCoefficientCarBrand(null);
        verify(carBrandRepository).getCoefficientCarBrand(isNull());

    }

    @Test
    void delete() {
        underTest.delete(1);
        verify(carBrandRepository).deleteById(1);
    }

    @Test
    void delete_nullReturned() {
        underTest.delete(null);
        verify(carBrandRepository).deleteById(isNull());
    }

    @Test
    void updateWithCheck() {
    }
}