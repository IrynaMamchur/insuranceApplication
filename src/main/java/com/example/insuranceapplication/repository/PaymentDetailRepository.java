package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.entity.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PaymentDetailRepository extends JpaRepository<PaymentDetail, Integer> {

@Query(value = "SELECT " +
        "PaymentDetail.payment1\n" +
        "FROM PaymentDetail \n" +
        "where PaymentDetail .id = :id", nativeQuery = true)
double getPayment1 (@Param("id") Integer id);

    @Query(value = "SELECT " +
            "PaymentDetail.payment2\n" +
            "FROM PaymentDetail \n" +
            "where PaymentDetail .id = :id", nativeQuery = true)
    double getPayment2 (@Param("id") Integer id);

}
