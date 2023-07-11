package com.example.insuranceapplication.repository.carRepository;

import com.example.insuranceapplication.entity.car.CarQuantityOfPayments;
import com.example.insuranceapplication.entity.enam.CarQuantityOfPaymentsNumbers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarQuantityOfPaymentsRepository extends JpaRepository<CarQuantityOfPayments, Integer> {

    @Query(value = "SELECT " +
            "CarQuantityOfPayments .coefficient\n" +
            "FROM CarQuantityOfPayments  \n" +
            "where CarQuantityOfPayments .number = :number ", nativeQuery = true)
    double getCoefficientCarNumberOfPayments(@Param("number") CarQuantityOfPaymentsNumbers number);
}

