package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.car.CarBrand;
import com.example.insuranceapplication.repository.CarBrandRepository;
import com.example.insuranceapplication.service.database.CarBrandDatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarBrandDatabaseServiceImpl implements CarBrandDatabaseService {
    private final CarBrandRepository carBrandRepository;

    @Override
    public CarBrand getCarBrandByName(String carBrandName) {
        return carBrandRepository.getBrandByCarBrandName(carBrandName);
    }

    @Override
    public Optional<CarBrand> getCarBrandById(int id) {
        return carBrandRepository.findById(id);
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
    public double getCoefficientCarBrand(String carBrandName) {
        return carBrandRepository.getCoefficientCarBrand(carBrandName);
    }

    @Override
    public CarBrand update(CarBrand carBrand) {
        return carBrandRepository.save(carBrand);
    }


}
