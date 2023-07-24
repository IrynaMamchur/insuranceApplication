package com.example.insuranceapplication.repository.carRepository;

import com.example.insuranceapplication.entity.car.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CarBrandRepository extends JpaRepository<CarBrand, Integer> {
    CarBrand getBrandByCarBrandName(String carBrandName);

    @Query(value = "SELECT" +
            " carBrand.coefficient " +
            "FROM CarBrand carBrand " +
            " where carBrand.carBrandName like :carBrandName")
    double getCoefficientCarBrand(@Param("carBrandName") String carBrandName);


}
