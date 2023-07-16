package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.InsurancePayment;
import com.example.insuranceapplication.entity.dto.InsurancePaymentDto;
import com.example.insuranceapplication.entity.updateDto.InsurancePaymentUpdateDto;

import java.util.Optional;

public interface InsurancePaymentDatabaseService {
    InsurancePayment create(InsurancePayment insurancePayment);

    double createInsurancePayment(Integer coefficientId, Double carCost);

    double getAmount(Integer id);

    Optional<InsurancePayment> updateInsurancePayment(InsurancePaymentDto insurancePaymentDto);

    void delete(Integer id);

    Optional<InsurancePayment> updateWithCheck(Integer id, InsurancePaymentUpdateDto insurancePaymentUpdateDto);

}
