package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.car.CarBrand;
import com.example.insuranceapplication.entity.updateDto.CarBrandUpdateDto;

import java.util.List;
import java.util.Optional;

public interface CarBrandDatabaseService {

    CarBrand getCarBrandByName(String carBrandName);

    Optional<CarBrand> getCarBrandById(int id);

    List<CarBrand> getCarBrands();

    CarBrand update(CarBrand carBrand);

    CarBrand create(CarBrand carBrand);

    double getCoefficientCarBrand(String carBrandName);

    void delete(Integer id);

    Optional<CarBrand> updateWithCheck(Integer id, CarBrandUpdateDto carBrandUpdateDto);

}
