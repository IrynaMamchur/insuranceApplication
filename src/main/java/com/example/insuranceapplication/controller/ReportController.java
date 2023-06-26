package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.entity.PaymentDetail;
import com.example.insuranceapplication.service.database.ReportDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReportController {
    private final ReportDatabaseService reportDatabaseService;

    @GetMapping(value = "/report/find/{startedAt}")
    public List<ContractNumber> getAllPaymentDetails(@PathVariable(name = "startedAt") Timestamp startedAt) {
        List<ContractNumber> contractNumbers = reportDatabaseService.createFirstReport(startedAt);
        return contractNumbers;
    }
}
