package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.Coefficient;
import com.example.insuranceapplication.entity.InsurancePayment;

import java.util.Optional;

public interface InsurancePaymentDatabaseService {
    InsurancePayment create(InsurancePayment insurancePayment);
    double createInsurancePayment(Integer coefficientId, Integer carCostId);

    double getAmount(Integer id);

    Optional<InsurancePayment> updateInsurancePayment(Integer id, Integer coefficientId, Integer carCostId);
}
