package com.example.insuranceapplication.service.database;


import java.util.List;


public interface ReportDatabaseService {
    /**
     * Create Report from insurance payment and car cost
     * @param insurancePaymentAmount The insurancePaymentAmount from InsurancePayment
     * @return The Report from insurance payment and car cost
     */
    List<Object> createFirstReport(Double insurancePaymentAmount);
}
