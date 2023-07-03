package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.car.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CarBrandRepository extends JpaRepository<CarBrand, Integer> {
    CarBrand getBrandByCarBrandNameAndCarModelName(String carBrandName, String carModelName);

    Collection<CarBrand> getCarBrandByCarBrandName(String carBrandName);

    @Query(value = "SELECT " +
            "CarBrand.coefficient\n" +
            "FROM CarBrand \n" +
            "where CarBrand.carBrandName = :carBrandName AND CarBrand .carModelName = :carModelName")
    double getCoefficientCarBrand(@Param("carBrandName") String carBrandName, @Param("carModelName") String carModelName);
}
