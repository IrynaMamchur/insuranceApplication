package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.ClientRequests;
import com.example.insuranceapplication.entity.Coefficient;
import com.example.insuranceapplication.entity.enam.CarQuantityOfPaymentsNumbers;
import com.example.insuranceapplication.service.database.CoefficientDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CoefficientController {

    private final CoefficientDatabaseService coefficientDatabaseService;



    @PostMapping(value = "/coefficient/create")
    public ResponseEntity <Coefficient> createCoefficient(@RequestBody Coefficient coefficient) {
        coefficientDatabaseService.create(coefficient);
        return ResponseEntity.ok(coefficient);
    }

    @GetMapping(value = "/coefficient/find/id/{id}")
    public ResponseEntity <Double>  getCoefficientByID(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(coefficientDatabaseService.getCoefficient(id));
    }

    @PutMapping(value = "/coefficient/update/coefficientForCar")
    public ResponseEntity <Optional<Coefficient>> updateCoefficientForCar(@RequestBody Integer id, String carBrandName, Double engineCapacity, String insuranceProgramName, Integer carFirstRegistr, CarQuantityOfPaymentsNumbers number) {
        Optional<Coefficient> coefficient =  coefficientDatabaseService.updateCoefficientForCar(id, carBrandName, engineCapacity, insuranceProgramName, carFirstRegistr, number);
        return ResponseEntity.ok(coefficient);
    }


    private ResponseEntity<List<Coefficient>> createResponseEntity(List<Coefficient> coefficients) {
        if (coefficients != null && !coefficients.isEmpty()) {
            return ResponseEntity.ok(coefficients);
        } else {
            return ResponseEntity.noContent().build();
        }
    }


}
