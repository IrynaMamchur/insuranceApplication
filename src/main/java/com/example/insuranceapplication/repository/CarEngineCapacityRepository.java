package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.car.CarEngineCapacity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarEngineCapacityRepository extends JpaRepository<CarEngineCapacity, Integer> {
    CarEngineCapacity getEngineCapacity(Double engineCapacity);

}
