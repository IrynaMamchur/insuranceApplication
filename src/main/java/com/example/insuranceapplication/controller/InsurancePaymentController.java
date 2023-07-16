package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.InsurancePayment;
import com.example.insuranceapplication.entity.dto.InsurancePaymentDto;
import com.example.insuranceapplication.entity.updateDto.InsurancePaymentUpdateDto;
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

    @GetMapping(value = "/insurancePayment/create/{coefficientId}/{carCost}")
    public ResponseEntity<Double> createNewInsurancePayment(@PathVariable(name = "coefficientId") Integer coefficientId, @PathVariable(name = "carCost") Double carCost) {
        Double amount = insurancePaymentDatabaseService.createInsurancePayment(coefficientId, carCost);
        return ResponseEntity.ok(amount);
    }

    @GetMapping(value = "/insurancePayment/find/insurancePaymentAmount/id/{id}")
    public ResponseEntity<Double> getAmount(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(insurancePaymentDatabaseService.getAmount(id));
    }

    @PostMapping(value = "/insurancePayment/create")
    public ResponseEntity<InsurancePayment> create(@RequestBody InsurancePayment insurancePayment) {
        insurancePaymentDatabaseService.create(insurancePayment);
        return ResponseEntity.ok(insurancePayment);
    }

    @PutMapping(value = "/insurancePayment/update/insurancePaymentAmount")
    public ResponseEntity<Optional<InsurancePayment>> updateInsurancePayment(@RequestBody InsurancePaymentDto insurancePaymentDto) {
        Optional<InsurancePayment> insurancePayment = insurancePaymentDatabaseService.updateInsurancePayment(insurancePaymentDto);
        return ResponseEntity.ok(insurancePayment);
    }

    @PutMapping(value = "/insurancePayment/update/withCheck/{id}")
    public ResponseEntity<Optional<InsurancePayment>> updateWithCheck(@PathVariable(name = "id") Integer id, @RequestBody InsurancePaymentUpdateDto insurancePaymentUpdateDto) {
        Optional<InsurancePayment> insurancePayment = insurancePaymentDatabaseService.updateWithCheck(id, insurancePaymentUpdateDto);
        return ResponseEntity.ok(insurancePayment);
    }

    @DeleteMapping(value = "/insurancePayment/delete/{id}")
    public ResponseEntity<Integer> delete(@PathVariable Integer id) {
        insurancePaymentDatabaseService.delete(id);
        return ResponseEntity.ok().build();
    }

    private ResponseEntity<List<InsurancePayment>> createResponseEntity(List<InsurancePayment> insurancePayments) {
        if (insurancePayments != null && !insurancePayments.isEmpty()) {
            return ResponseEntity.ok(insurancePayments);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
