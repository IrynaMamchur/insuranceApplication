package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.service.database.InsurancePaymentDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InsurancePaymentController {

    private final InsurancePaymentDatabaseService insurancePaymentDatabaseService;

    @PostMapping(value = "/insurancePayment/create")
    public double createInsurancePayment(@RequestBody Integer coefficientId, Integer id) {
        return insurancePaymentDatabaseService.createInsurancePayment(coefficientId, id);
    }

}
