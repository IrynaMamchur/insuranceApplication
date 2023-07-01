package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.car.CarBrand;
import com.example.insuranceapplication.entity.car.CarEngineCapacity;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CarEngineCapacityDatabaseService {
//   CarEngineCapacity getEngineCapacity(Double engineCapacity);

    Optional<CarEngineCapacity> getCarEngineCapacityById(Integer id);

    List<CarEngineCapacity> getAllCarEngineCapacity();

    CarEngineCapacity create(CarEngineCapacity carEngineCapacity);

    CarEngineCapacity update(CarEngineCapacity carEngineCapacity);

    double getCoefficientCarEngineCapacity (Double engineCapacity);
}
