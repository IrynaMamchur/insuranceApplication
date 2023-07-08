package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.InsurancePayment;
import com.example.insuranceapplication.entity.dto.InsurancePaymentDto;
import com.example.insuranceapplication.service.database.InsurancePaymentDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping(value = "/insurancePayment/update/insurancePaymentAmount")
    public ResponseEntity <Optional<InsurancePayment>> updateInsurancePayment(@RequestBody InsurancePaymentDto insurancePaymentDto) {
        Optional<InsurancePayment> insurancePayment =  insurancePaymentDatabaseService.updateInsurancePayment(insurancePaymentDto);
        return ResponseEntity.ok(insurancePayment);
    }

    @GetMapping(value = "/insurancePayment/find/insurancePaymentAmount/id/{id}")
    public ResponseEntity <Double>  getAmount(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(insurancePaymentDatabaseService.getAmount(id));
    }

    private ResponseEntity<List<InsurancePayment>> createResponseEntity(List<InsurancePayment> insurancePayments) {
        if (insurancePayments != null && !insurancePayments.isEmpty()) {
            return ResponseEntity.ok(insurancePayments);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
