package com.example.insuranceapplication.repository.carRepository;

import com.example.insuranceapplication.entity.car.CarEngineCapacity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarEngineCapacityRepository extends JpaRepository<CarEngineCapacity, Integer> {
    CarEngineCapacity getEngineCapacityByEngineCapacityEquals(Double engineCapacity);

    @Query(value = "SELECT " +
            "coefficient" +
            " FROM CarEngineCapacity" +
            " where engineCapacity = :engineCapacity")
    double getCoefficientCarEngineCapacity(@Param("engineCapacity") Double engineCapacity);

}
