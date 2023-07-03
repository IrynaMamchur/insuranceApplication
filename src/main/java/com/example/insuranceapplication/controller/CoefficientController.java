package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.ClientRequests;
import com.example.insuranceapplication.entity.Coefficient;
import com.example.insuranceapplication.entity.enam.CarQuantityOfPaymentsNumbers;
import com.example.insuranceapplication.service.database.CoefficientDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CoefficientController {

    private final CoefficientDatabaseService coefficientDatabaseService;

    @GetMapping(value = "/coefficient/create/{carBrandName}/{engineCapacity}/{insuranceProgramName}/{carFirstRegistr}/{number}")
    public ResponseEntity <Double> getNewCoefficient(@PathVariable(name = "carBrandName") String carBrandName,@PathVariable(name = "engineCapacity") Double engineCapacity, @PathVariable(name = "insuranceProgramName")String insuranceProgramName,@PathVariable(name = "carFirstRegistr") Integer carFirstRegistr, @PathVariable(name = "number")CarQuantityOfPaymentsNumbers number) {
        Double coefficientForCar = coefficientDatabaseService.createCoefficient(carBrandName, engineCapacity, insuranceProgramName, carFirstRegistr, number);
        return ResponseEntity.ok(coefficientForCar);
    }


    @PostMapping(value = "/coefficient/create")
    public ResponseEntity <Coefficient> createCoefficient(@RequestBody Coefficient coefficient) {
        coefficientDatabaseService.create(coefficient);
        return ResponseEntity.ok(coefficient);
    }

    @GetMapping(value = "/coefficient/find/id/{id}")
    public ResponseEntity <Double>  getCoefficientByID(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(coefficientDatabaseService.getCoefficient(id));
    }

    private ResponseEntity<List<Coefficient>> createResponseEntity(List<Coefficient> coefficients) {
        if (coefficients != null && !coefficients.isEmpty()) {
            return ResponseEntity.ok(coefficients);
        } else {
            return ResponseEntity.noContent().build();
        }
    }


}
