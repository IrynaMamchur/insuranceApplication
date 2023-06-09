package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.entity.payment.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PaymentDetailRepository extends JpaRepository<PaymentDetail, Integer> {

    @Query(value = "SELECT " +
            "PaymentDetail.payment\n" +
            "FROM PaymentDetail \n" +
            "where PaymentDetail .id = :id", nativeQuery = true)
    Integer getPayment(@Param("id") Integer id);

    Collection<PaymentDetail> findAllByContractNumber(ContractNumber contractNumber);

}
