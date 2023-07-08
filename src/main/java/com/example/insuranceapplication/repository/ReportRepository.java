package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.entity.InsurancePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Collection;
@Repository
public interface ReportRepository extends JpaRepository <ContractNumber, Integer>  {


    @Query("SELECT cn.id, cr.carCost, ir.insurancePaymentAmount FROM ContractNumber cn, ClientRequests cr, InsurancePayment ir" +
            " WHERE cn.startedAt = :startedAt")
    Collection<ContractNumber> createFirstReport(@Param("startedAt") Timestamp startedAt);

}
