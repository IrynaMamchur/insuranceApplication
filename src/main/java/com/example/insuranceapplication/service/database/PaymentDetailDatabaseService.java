package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.PaymentDetail;
import com.example.insuranceapplication.repository.PaymentDetailRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentDetailDatabaseService {

    List<PaymentDetail> getPaymentDetailByAmountAll(Double amountAll);

    List<PaymentDetail> getAllPaymentDetails();

    Optional<PaymentDetail> getPaymentDetailById(Integer id);

    PaymentDetail create(PaymentDetail paymentDetail);

    PaymentDetail update(PaymentDetail paymentDetail);


}
