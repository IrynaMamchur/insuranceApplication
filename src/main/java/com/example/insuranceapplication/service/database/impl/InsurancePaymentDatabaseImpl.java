package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.InsurancePayment;
import com.example.insuranceapplication.repository.InsurancePaymentRepository;
import com.example.insuranceapplication.service.database.ClientReguestsDatabaseService;
import com.example.insuranceapplication.service.database.CoefficientDatabaseService;
import com.example.insuranceapplication.service.database.InsurancePaymentDatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InsurancePaymentDatabaseImpl implements InsurancePaymentDatabaseService {

    private final InsurancePaymentRepository insurancePaymentRepository;
    private final CoefficientDatabaseService coefficientDatabaseService;
    private final ClientReguestsDatabaseService clientReguestsDatabaseService;


    @Override
    public InsurancePayment create(InsurancePayment insurancePayment) {
        return insurancePaymentRepository.save(insurancePayment);
    }

    @Override
    public double createInsurancePayment(Integer coefficientId, Integer id) {
        double coefficientForCar;
        double amount;
        double carCost;
        coefficientForCar = coefficientDatabaseService.getCoefficient(coefficientId);
        carCost = clientReguestsDatabaseService.getCarCostClientRequests(id);
        if (coefficientForCar <=0 || carCost <=0) {
            throw new IllegalArgumentException();
        }

        insurancePaymentRepository.createInsurancePayment(coefficientForCar, carCost);
        {
            amount = coefficientForCar * carCost;
        }
        return amount;
    }
}
