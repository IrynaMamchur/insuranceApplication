package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.car.CarBrand;
import com.example.insuranceapplication.repository.CarBrandRepository;
import com.example.insuranceapplication.service.database.CarBrandDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarBrandDatabaseServiceImpl implements CarBrandDatabaseService {
    private final CarBrandRepository carBrandRepository;

    @Override
    public CarBrand getCarBrandByName(String carBrandName, String carModelName) {
        return carBrandRepository.getBrandByCarBrandNameAndCarModelName(carBrandName, carModelName);
    }

    @Override
    public Optional<CarBrand> getCarBrandById(int id) {
        return carBrandRepository.findById(id);
    }

    @Override
    public List<CarBrand> getCarBrandByCarBrandName(String carBrandName) {
        return (List<CarBrand>) carBrandRepository.getCarBrandByCarBrandName(carBrandName);
    }

    @Override
    public List<CarBrand> getCarBrands() {
        return carBrandRepository.findAll();
    }

    @Override
    public CarBrand create(CarBrand carBrand) {
        return carBrandRepository.save(new CarBrand());
    }

    @Override
    public double getCoefficientCarBrand(String carBrandName, String carModelName) {
        return carBrandRepository.getCoefficientCarBrand(carBrandName, carModelName);
    }

    @Override
    public CarBrand update(CarBrand carBrand) {
        return carBrandRepository.save(carBrand);
    }


}
