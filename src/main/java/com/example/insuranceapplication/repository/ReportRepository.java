package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.entity.InsurancePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<InsurancePayment, Integer> {


    @Query("SELECT DISTINCT ir.carCost, ir.insurancePaymentAmount FROM InsurancePayment ir " +
            " WHERE ir.insurancePaymentAmount >= :insurancePaymentAmount")
    List<Object>  createFirstReport(@Param("insurancePaymentAmount") Double insurancePaymentAmount);



}
