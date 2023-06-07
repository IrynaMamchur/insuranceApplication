package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.car.Brand;
import com.example.insuranceapplication.entity.car.EngineCapacity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarEngineCapacityRepository extends JpaRepository<EngineCapacity, Integer> {
}
