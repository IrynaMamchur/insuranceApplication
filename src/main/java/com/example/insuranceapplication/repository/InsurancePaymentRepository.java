package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.InsurancePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface InsurancePaymentRepository extends JpaRepository<InsurancePayment, Integer> {

    /**
     * Find insurance payment from database by specified InsurancePayment id
     * @param id  The id of the InsurancePayment
     * @return The insurance payment from database by specified InsurancePayment id
     */
    @Query(value = "SELECT " +
            "insurancePaymentAmount" +
            " FROM InsurancePayment ip" +
            " where id = :id", nativeQuery = true)
    double getAmount(@Param("id") Integer id);

}
