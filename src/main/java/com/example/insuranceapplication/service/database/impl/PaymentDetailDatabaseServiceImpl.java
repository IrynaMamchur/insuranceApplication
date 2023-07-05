package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.entity.Payment;
import com.example.insuranceapplication.entity.PaymentDetail;
import com.example.insuranceapplication.entity.dto.PaymentDetailDto;
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
    public List<PaymentDetail> getAllPaymentDetailsByContractNumber(ContractNumber contractNumber) {
        return (List<PaymentDetail>) paymentDetailRepository.findAllByContractNumber(contractNumber);
    }

    @Override
    public Integer getPayment(Integer id) {
        return paymentDetailRepository.getPayment(id);
    }

    @Override
    public Optional<PaymentDetail> updatePayment(PaymentDetailDto paymentDetailDto) {
        ContractNumber contractNumber = paymentDetailDto.getContractNumberId();
        Payment paymentId = paymentDetailDto.getPaymentId();
        List<PaymentDetail> paymentDetailsWithOnceContractNumber = getAllPaymentDetailsByContractNumber(contractNumber);
        for (int i = 0; i < paymentDetailsWithOnceContractNumber.size(); i++) {
            if (getPayment(i) == null) {
                PaymentDetail paymentDetail = paymentDetailsWithOnceContractNumber.get(i);
                paymentDetail.setPayment(paymentId);
                paymentDetailRepository.save(paymentDetail);
                return Optional.of(paymentDetail);
            }
        }
        return null;
    }
}