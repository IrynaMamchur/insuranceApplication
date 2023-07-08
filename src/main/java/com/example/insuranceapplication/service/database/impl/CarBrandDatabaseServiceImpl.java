package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.car.CarBrand;
import com.example.insuranceapplication.entity.updateDto.CarBrandUpdateDto;
import com.example.insuranceapplication.repository.carRepository.CarBrandRepository;
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
    public void delete(Integer id) {
        carBrandRepository.deleteById(id);
    }

    @Override
    public Optional<CarBrand> updateWithCheck(Integer id, CarBrandUpdateDto carBrandUpdateDto) {
        Optional<CarBrand> carBrandOptional = carBrandRepository.findById(id);
        if (carBrandOptional.isPresent() && carBrandUpdateDto != null) {
            CarBrand carBrand = carBrandOptional.get();
            if (carBrandUpdateDto.getCarBrandName() != null) {
                carBrand.setCarBrandName(carBrandUpdateDto.getCarBrandName());
            }
            if (carBrandUpdateDto.getCoefficient() != null) {
                carBrand.setCoefficient(carBrandUpdateDto.getCoefficient());
            }
            carBrandRepository.save(carBrand);
            return Optional.of(carBrand);
        }
        return Optional.empty();
    }

    @Override
    public CarBrand update(CarBrand carBrand) {
        return carBrandRepository.save(carBrand);
    }

}
