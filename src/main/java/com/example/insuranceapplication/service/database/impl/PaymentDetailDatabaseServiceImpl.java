package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.Payment;
import com.example.insuranceapplication.entity.PaymentDetail;
import com.example.insuranceapplication.repository.PaymentDetailRepository;
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
//    @Override
//    public List<PaymentDetail> getPaymentDetailByAmountAll(Double amountAll) {
//        return (List<PaymentDetail>) paymentDetailRepository.getPaymentDetailByAmountAll(amountAll);
//    }

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

}
