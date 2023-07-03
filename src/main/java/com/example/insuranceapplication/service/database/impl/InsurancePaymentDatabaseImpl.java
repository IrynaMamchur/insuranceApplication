package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.repository.InsurancePaymentRepository;
import com.example.insuranceapplication.service.database.ClientReguestsDatabaseService;
import com.example.insuranceapplication.service.database.CoefficientDatabaseService;
import com.example.insuranceapplication.service.database.InsurancePaymentDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsurancePaymentDatabaseImpl implements InsurancePaymentDatabaseService {

    private final InsurancePaymentRepository insurancePaymentRepository;
    private final CoefficientDatabaseService coefficientDatabaseService;
    private final ClientReguestsDatabaseService clientReguestsDatabaseService;

public Double coefficientForCar;

    public Double amount;
    public Double carCost;


    @Override
    public double createInsurancePayment(Integer coefficientId, Integer id) {

            coefficientForCar = coefficientDatabaseService.getCoefficient(coefficientId);
            carCost = clientReguestsDatabaseService.getCarCostClientRequests(id);
            insurancePaymentRepository.createInsurancePayment(coefficientForCar, carCost);
            {amount = coefficientForCar * carCost;}
            return amount;
        }
}
