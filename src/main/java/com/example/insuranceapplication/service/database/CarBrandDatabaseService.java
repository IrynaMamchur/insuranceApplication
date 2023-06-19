package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.car.CarBrand;

import java.util.List;
import java.util.Optional;

public interface CarBrandDatabaseService {

    CarBrand getCarBrandByName(String carBrandName, String carModelName);

    Optional<CarBrand> getCarBrandById(int id);

    List<CarBrand> getCarBrandByCarBrandName(String carBrandName);

    List<CarBrand> getCarBrands();

    CarBrand update(CarBrand carBrand);

    CarBrand create(CarBrand carBrand);

}
