package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.car.CarEngineCapacity;
import com.example.insuranceapplication.entity.updateDto.CarEngineCapacityUpdateDto;

import java.util.List;
import java.util.Optional;

public interface CarEngineCapacityDatabaseService {
 CarEngineCapacity getEngineCapacity(Double engineCapacity);

 Optional<CarEngineCapacity> getCarEngineCapacityById(Integer id);

 List<CarEngineCapacity> getAllCarEngineCapacity();

 CarEngineCapacity create(CarEngineCapacity carEngineCapacity);

 CarEngineCapacity update(CarEngineCapacity carEngineCapacity);

 double getCoefficientCarEngineCapacity(Double engineCapacity);

 void delete(Integer id);

 Optional<CarEngineCapacity> updateWithCheck(Integer id, CarEngineCapacityUpdateDto carEngineCapacityUpdateDto);

}
