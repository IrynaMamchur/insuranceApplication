package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.PaymentDetail;
import com.example.insuranceapplication.repository.PaymentDetailRepository;
import com.example.insuranceapplication.service.database.PaymentDatabaseService;
import com.example.insuranceapplication.service.database.PaymentDetailDatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentDetailDatabaseServiceImpl implements PaymentDetailDatabaseService {
private final PaymentDetailRepository paymentDetailRepository;
private final PaymentDatabaseService paymentDatabaseService;

    @Override
    public List<PaymentDetail> getAllPaymentDetails() {
        return paymentDetailRepository.findAll();
    }

    @Override
    public Optional<PaymentDetail> getPaymentDetailById(Integer id) {
        return paymentDetailRepository.findById(id);
    }

    @Override
    public PaymentDetail create(PaymentDetail paymentDetail) {
        return paymentDetailRepository.save(new PaymentDetail());
    }

    @Override
    public PaymentDetail update(PaymentDetail paymentDetail) {
        return paymentDetailRepository.save(paymentDetail);
    }

    @Override
    public Optional<PaymentDetail> updatePayment(Integer id, Integer payment1, Integer payment2) {
        Optional<PaymentDetail> paymentDetailOptional = paymentDetailRepository.findById(id);
        if (paymentDetailOptional.isPresent() && payment1 ==null) {
            PaymentDetail paymentDetail = paymentDetailOptional.get();
            paymentDetail.setPayment1 (paymentDatabaseService.getPaymentId(id));
            paymentDetailRepository.save(paymentDetail);
            return Optional.of(paymentDetail);
        } else if (paymentDetailOptional.isPresent() && payment1 !=null && payment2 ==null) {
            PaymentDetail paymentDetail = paymentDetailOptional.get();
            paymentDetail.setPayment2(paymentDatabaseService.getPaymentId(id));
            paymentDetailRepository.save(paymentDetail);
            return Optional.of(paymentDetail);
        }
        return null;
    }



}
