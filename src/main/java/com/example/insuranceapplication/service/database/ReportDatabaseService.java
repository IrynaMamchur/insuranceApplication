package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.ContractNumber;

import java.sql.Timestamp;
import java.util.List;


public interface ReportDatabaseService {
    List<ContractNumber> createFirstReport(Timestamp startedAt);
}
