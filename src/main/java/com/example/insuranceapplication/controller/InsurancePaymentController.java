package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.Coefficient;
import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.entity.InsurancePayment;
import com.example.insuranceapplication.entity.enam.CarQuantityOfPaymentsNumbers;
import com.example.insuranceapplication.service.database.InsurancePaymentDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InsurancePaymentController {

    private final InsurancePaymentDatabaseService insurancePaymentDatabaseService;

    @GetMapping(value = "/insurancePayment/create/{coefficientId}/{id}")
    public ResponseEntity<Double> createNewInsurancePayment(@PathVariable(name = "coefficientId") Integer coefficientId, @PathVariable(name = "id") Integer id) {
        Double amount = insurancePaymentDatabaseService.createInsurancePayment(coefficientId, id);
        return ResponseEntity.ok(amount);
    }

    @PostMapping(value = "/insurancePayment/create")
    public ResponseEntity <InsurancePayment> create(@RequestBody InsurancePayment insurancePayment) {
        insurancePaymentDatabaseService.create(insurancePayment);
        return ResponseEntity.ok(insurancePayment);
    }


    private ResponseEntity<List<InsurancePayment>> createResponseEntity(List<InsurancePayment> insurancePayments) {
        if (insurancePayments != null && !insurancePayments.isEmpty()) {
            return ResponseEntity.ok(insurancePayments);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
