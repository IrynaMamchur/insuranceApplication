package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.entity.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PaymentDetailRepository extends JpaRepository<PaymentDetail, Integer> {
//    Collection<PaymentDetail> getPaymentDetailByAmountAll(Double amountAll);
}
