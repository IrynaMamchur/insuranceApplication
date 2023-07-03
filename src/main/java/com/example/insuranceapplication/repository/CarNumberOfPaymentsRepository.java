package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.Coefficient;
import com.example.insuranceapplication.entity.enam.CarNumberOfPaymentsNumbers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarNumberOfPaymentsRepository extends JpaRepository<CarNumberOfPaymentsNumbers, Integer> {

    @Query(value = "SELECT " +
            "CarNumberOfPayments .coefficient\n" +
            "FROM CarNumberOfPayments  \n" +
            "where CarNumberOfPayments .number = :number ")
    double getCoefficientCarNumberOfPayments(@Param("number") CarNumberOfPaymentsNumbers number);
}

