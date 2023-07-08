package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.InsurancePayment;
import com.example.insuranceapplication.entity.dto.InsurancePaymentDto;

import java.util.Optional;

public interface InsurancePaymentDatabaseService {
    InsurancePayment create(InsurancePayment insurancePayment);
    double createInsurancePayment(Integer coefficientId, Integer carCostId);

    double getAmount(Integer id);

    Optional<InsurancePayment> updateInsurancePayment(InsurancePaymentDto insurancePaymentDto);
}
