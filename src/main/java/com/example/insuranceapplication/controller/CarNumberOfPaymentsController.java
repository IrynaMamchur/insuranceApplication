package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.enam.CarNumberOfPaymentsNumbers;
import com.example.insuranceapplication.service.database.CarNumberOfPaymentsDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CarNumberOfPaymentsController {

    private final CarNumberOfPaymentsDatabaseService carNumberOfPaymentsDatabaseService;

    @GetMapping(value = "/car_number_of_payments/find/coefficient/{number}")
    public double getCoefficientCarNumberOfPayments(@PathVariable(name = "number") CarNumberOfPaymentsNumbers number) {
        return carNumberOfPaymentsDatabaseService.getCoefficientCarNumberOfPayments(number);
    }

}
