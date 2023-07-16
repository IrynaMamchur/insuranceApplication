package com.example.insuranceapplication.controller;

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
    public ResponseEntity<List<Object[]>> getAllPaymentDetails(@PathVariable(name = "insurancePaymentAmount") Double insurancePaymentAmount) {
        List<Object[]>contractNumbers = reportDatabaseService.createFirstReport(insurancePaymentAmount);
        return createResponseEntity(contractNumbers);
    }

    private ResponseEntity<List<Object[]>> createResponseEntity(List<Object[]> contractNumbers) {
        if (contractNumbers != null && !contractNumbers.isEmpty() ) {
                return ResponseEntity.ok(contractNumbers);
        } else {
            return ResponseEntity.noContent().build();
        }
    }


}
