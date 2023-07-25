package com.example.insuranceapplication.repository.carRepository;

import com.example.insuranceapplication.entity.car.CarQuantityOfPayments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarQuantityOfPaymentsRepository extends JpaRepository<CarQuantityOfPayments, Integer> {

    /**
     * Finds coefficient from database by specified CarQuantityOfPayments number
     * @param number The Integer number of the CarQuantityOfPayments
     * @return The coefficient from database that was found by the specified CarQuantityOfPayments number of the CarQuantityOfPayments
     */
    @Query(value = "SELECT " +
            " carQuantityOfPayments.coefficient" +
            " FROM CarQuantityOfPayments carQuantityOfPayments" +
            " where carQuantityOfPayments.number = :number ")
    double getCoefficientCarNumberOfPayments(@Param("number") Integer number);
}

