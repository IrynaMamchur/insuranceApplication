package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.car.CarEngineCapacity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarEngineCapacityRepository extends JpaRepository<CarEngineCapacity, Integer> {
//   CarEngineCapacity getEngineCapacity(Double engineCapacity);

    @Query(value = "SELECT " +
            "CarEngineCapacity.coefficient\n" +
            "FROM CarEngineCapacity \n" +
            "where CarEngineCapacity .engineCapacity = :engineCapacity", nativeQuery = true)
    double getCoefficientCarEngineCapacity(@Param("engineCapacity") Double engineCapacity);

}
