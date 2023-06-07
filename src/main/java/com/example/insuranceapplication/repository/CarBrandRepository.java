package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.car.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarBrandRepository extends JpaRepository<Brand, Integer> {

}
