package com.example.insuranceapplication.repository.carRepository;

import com.example.insuranceapplication.entity.car.CarEngineCapacity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarEngineCapacityRepository extends JpaRepository<CarEngineCapacity, Integer> {

    /**
     * Finds an СarEngineCapacity entity from database by engineCapacity
     *
     * @param engineCapacity The Double engineCapacity of the CarEngineCapacity
     * @return CarEngineCapacity entity from database that was found by the engineCapacity of the CarEngineCapacity
     */
    CarEngineCapacity getEngineCapacityByEngineCapacityEquals(Double engineCapacity);

    /**
     * Finds coefficient from database by specified CarEngineCapacity engineCapacity
     *
     * @param engineCapacity The engineCapacity of the CarEngineCapacity
     * @return The coefficient from database that was found by the engineCapacity of the CarEngineCapacity
     */
    @Query(value = "SELECT " +
            "coefficient" +
            " FROM CarEngineCapacity" +
            " where engineCapacity = :engineCapacity")
    double getCoefficientCarEngineCapacity(@Param("engineCapacity") Double engineCapacity);


}
