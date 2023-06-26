package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.Coefficient;
import com.example.insuranceapplication.entity.enam.CarNumberOfPaymentsNumbers;
import com.example.insuranceapplication.service.database.CoefficientDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CoefficientController {

    private final CoefficientDatabaseService coefficientDatabaseService;

    @PostMapping(value = "/coefficient/create")
    public Coefficient createCoefficient(@RequestBody String carBrandName, String carModelName, Double engineCapacity, String insuranceProgramName, Integer carFirstRegistr, CarNumberOfPaymentsNumbers number) {
        coefficientDatabaseService.createCoefficient(carBrandName, carModelName, engineCapacity, insuranceProgramName, carFirstRegistr, number);
        return new Coefficient();
    }


    @GetMapping(value = "/coefficient/find/id/{id}")
    public double getCoefficient(@PathVariable(name = "id") Integer id) {
        return coefficientDatabaseService.getCoefficient(id);
    }
}
