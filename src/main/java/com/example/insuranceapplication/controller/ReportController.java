package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.entity.InsurancePayment;
import com.example.insuranceapplication.service.database.ReportDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReportController {
    private final ReportDatabaseService reportDatabaseService;

    @GetMapping(value = "/report/find/{insurancePaymentAmount}")
    public ResponseEntity<List<Object>> getAllPaymentDetails(@PathVariable(name = "insurancePaymentAmount") Double insurancePaymentAmount) {
        List<Object>insurancePayments = reportDatabaseService.createFirstReport(insurancePaymentAmount);
        return createResponseEntity(insurancePayments);
    }

    private ResponseEntity<List<Object>> createResponseEntity(List<Object> insurancePayments) {
        if (insurancePayments != null && !insurancePayments.isEmpty() ) {
                return ResponseEntity.ok(insurancePayments);
        } else {
            return ResponseEntity.noContent().build();
        }
    }


}
