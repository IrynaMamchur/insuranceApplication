package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.entity.payment.Payment;
import com.example.insuranceapplication.entity.payment.PaymentDetail;
import com.example.insuranceapplication.entity.dto.PaymentDetailDto;
import com.example.insuranceapplication.entity.updateDto.PaymentDetailUpdateDto;
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
        return Optional.empty();
    }

    @Override
    public void delete(Integer id) {
        paymentDetailRepository.deleteById(id);
    }

    @Override
    public Optional<PaymentDetail> updateWithCheck(Integer id, PaymentDetailUpdateDto paymentDetailUpdateDto) {
        Optional<PaymentDetail> paymentDetailOptional = paymentDetailRepository.findById(id);
        if (paymentDetailOptional.isPresent() && paymentDetailUpdateDto != null) {
            PaymentDetail paymentDetail = paymentDetailOptional.get();
            if (paymentDetailUpdateDto.getPayment() != null) {
                paymentDetail.setPayment(paymentDetailUpdateDto.getPayment());
            }
            if (paymentDetailUpdateDto.getAmountPlan() != null) {
                paymentDetail.setAmountPlan(paymentDetailUpdateDto.getAmountPlan());
            }
            if (paymentDetailUpdateDto.getDatePaymentPlan() != null) {
                paymentDetail.setDatePaymentPlan(paymentDetailUpdateDto.getDatePaymentPlan());
            }
            if (paymentDetailUpdateDto.getCreatedAt() != null) {
                paymentDetail.setCreatedAt(paymentDetailUpdateDto.getCreatedAt());
            }
            if (paymentDetailUpdateDto.getNumber() != null) {
                paymentDetail.setNumber(paymentDetailUpdateDto.getNumber());
            }
            if (paymentDetailUpdateDto.getContractNumber() != null) {
                paymentDetail.setContractNumber(paymentDetailUpdateDto.getContractNumber());
            }
            paymentDetailRepository.save(paymentDetail);
            return Optional.of(paymentDetail);
        }
        return Optional.empty();
    }
}