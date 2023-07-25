package com.example.insuranceapplication.repository.carRepository;

import com.example.insuranceapplication.entity.car.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CarBrandRepository extends JpaRepository<CarBrand, Integer> {

    /**
     * Finds an СarBrand entity from database by car brand and model
     * @param carBrandName The brand and model name of the CarBrand.
     * @return CarBrand entity from database that was found by the brand and model of the CarBrand
     */

    CarBrand getBrandByCarBrandName(String carBrandName);

    /**
     * Finds coefficient from database by specified CarBrand brand and model name
     * @param carBrandName The String carBrandName of the CarBrand.
     * @return The coefficient from database that was found by the brand and model name of the CarBrand
     */

    @Query(value = "SELECT" +
            " carBrand.coefficient " +
            "FROM CarBrand carBrand " +
            " where carBrand.carBrandName like :carBrandName")
    double getCoefficientCarBrand(@Param("carBrandName") String carBrandName);


}
