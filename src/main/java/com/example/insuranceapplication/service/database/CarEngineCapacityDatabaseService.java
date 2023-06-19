package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.car.CarEngineCapacity;

import java.util.List;
import java.util.Optional;

public interface CarEngineCapacityDatabaseService {
    CarEngineCapacity getCarEngineCapacity(Double engineCapacity);

    Optional<CarEngineCapacity> getCarEngineCapacityById(Integer id);

   List<CarEngineCapacity> getAllCarEngineCapacity();

   CarEngineCapacity create(CarEngineCapacity carEngineCapacity);

    CarEngineCapacity update(CarEngineCapacity carEngineCapacity);
}
