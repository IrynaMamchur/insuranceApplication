package com.example.insuranceapplication.service.database;

import java.util.List;


public interface ReportDatabaseService {
    List<Object[]> createFirstReport(Double insurancePaymentAmount);
}
