package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.payment.PaymentDetail;
import com.example.insuranceapplication.entity.updateDto.PaymentDetailUpdateDto;

import java.util.List;
import java.util.Optional;

public interface PaymentDetailDatabaseService {

    List<PaymentDetail> getAllPaymentDetails();

    Optional<PaymentDetail> getPaymentDetailById(Integer id);

    PaymentDetail create(PaymentDetail paymentDetail);

    void delete(Integer id);

    Optional<PaymentDetail> updateWithCheck(Integer id, PaymentDetailUpdateDto paymentDetailUpdateDto);
}
