package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.ContractNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<ContractNumber, Integer> {


    @Query("SELECT DISTINCT cn.id, ir.carCost, ir.insurancePaymentAmount FROM ContractNumber cn, InsurancePayment ir, ClientRequests cr" +
            " WHERE ir.insurancePaymentAmount >= :insurancePaymentAmount")
    List<Object[]>  createFirstReport(@Param("insurancePaymentAmount") Double insurancePaymentAmount);

}
