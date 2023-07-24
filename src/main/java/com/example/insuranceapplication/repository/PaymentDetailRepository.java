package com.example.insuranceapplication.repository;


import com.example.insuranceapplication.entity.payment.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentDetailRepository extends JpaRepository<PaymentDetail, Integer> {

}
