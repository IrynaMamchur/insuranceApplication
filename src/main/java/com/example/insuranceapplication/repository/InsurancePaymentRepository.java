package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.InsurancePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface InsurancePaymentRepository extends JpaRepository<InsurancePayment, Integer> {

    @Query(value = "SELECT " +
            "InsurancePayment.insurancePaymentAmount\n" +
            "FROM InsurancePayment \n" +
            "where InsurancePayment .id = :id", nativeQuery = true)
    double getAmount(@Param("id") Integer id);

}
