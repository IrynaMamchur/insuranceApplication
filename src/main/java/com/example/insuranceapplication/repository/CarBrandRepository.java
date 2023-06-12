package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.car.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarBrandRepository extends JpaRepository<CarBrand, Integer> {
   CarBrand getBrandByCarBrandNameAndCarModelName (String carBrandName, String carModelName);

}
