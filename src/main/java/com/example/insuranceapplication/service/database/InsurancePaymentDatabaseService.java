package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.Coefficient;
import com.example.insuranceapplication.entity.InsurancePayment;

public interface InsurancePaymentDatabaseService {
    InsurancePayment create(InsurancePayment insurancePayment);
    double createInsurancePayment(Integer coefficientId, Integer carCost);
}
