package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.car.CarEngineCapacity;
import com.example.insuranceapplication.repository.CarEngineCapacityRepository;
import com.example.insuranceapplication.service.database.CarEngineCapacityDatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarEngineCapacityDatabaseServiceImpl implements CarEngineCapacityDatabaseService {
    private final CarEngineCapacityRepository carEngineCapacityRepository;

    @Override
    public CarEngineCapacity getEngineCapacity(Double engineCapacity) {
        return carEngineCapacityRepository.getEngineCapacityByEngineCapacityEquals(engineCapacity);
    }

    @Override
    public Optional<CarEngineCapacity> getCarEngineCapacityById(Integer id) {
        return carEngineCapacityRepository.findById(id);
    }

    @Override
    public List<CarEngineCapacity> getAllCarEngineCapacity() {
        return carEngineCapacityRepository.findAll();
    }


    @Override
    public CarEngineCapacity create(CarEngineCapacity carEngineCapacity) {
        return carEngineCapacityRepository.save(new CarEngineCapacity());
    }

    @Override
    public CarEngineCapacity update(CarEngineCapacity carEngineCapacity) {
        return carEngineCapacityRepository.save(carEngineCapacity);
    }

    @Override
    public double getCoefficientCarEngineCapacity(Double engineCapacity) {
        return carEngineCapacityRepository.getCoefficientCarEngineCapacity(engineCapacity);
    }
}
