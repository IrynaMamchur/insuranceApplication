package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.InsurancePayment;
import com.example.insuranceapplication.entity.dto.InsurancePaymentDto;
import com.example.insuranceapplication.entity.updateDto.InsurancePaymentUpdateDto;
import com.example.insuranceapplication.repository.InsurancePaymentRepository;
//import com.example.insuranceapplication.service.database.ClientReguestsDatabaseService;
import com.example.insuranceapplication.service.database.CoefficientDatabaseService;
import com.example.insuranceapplication.service.database.InsurancePaymentDatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class InsurancePaymentDatabaseImpl implements InsurancePaymentDatabaseService {

    private final InsurancePaymentRepository insurancePaymentRepository;
    private final CoefficientDatabaseService coefficientDatabaseService;


    @Override
    public InsurancePayment create(InsurancePayment insurancePayment) {
        return insurancePaymentRepository.save(insurancePayment);
    }

    @Override
    public double createInsurancePayment(Integer coefficientId, Double carCost) {
        double coefficientForCar;
        double amount;
        coefficientForCar = coefficientDatabaseService.getCoefficientCoefficient(coefficientId);
        if (coefficientForCar <= 0 || carCost <= 0) {
            throw new IllegalArgumentException();
        }
        amount = coefficientForCar * carCost/100;
        return amount;
    }

    @Override
    public double getAmount(Integer id) {
        return insurancePaymentRepository.getAmount(id);
    }

    @Override
    public Optional<InsurancePayment> updateInsurancePayment(InsurancePaymentDto insurancePaymentDto) {
        Integer coefficientId = insurancePaymentDto.getCoefficientId();
        Double carCost = insurancePaymentDto.getCarCost();
        Integer id = insurancePaymentDto.getId();
        Optional<InsurancePayment> insurancePaymentOptional = insurancePaymentRepository.findById(id);
        if (insurancePaymentOptional.isPresent()) {
            InsurancePayment insurancePayment = insurancePaymentOptional.get();
            insurancePayment.setInsurancePaymentAmount(createInsurancePayment(coefficientId, carCost));
            insurancePaymentRepository.save(insurancePayment);
            return Optional.of(insurancePayment);
        }
        return Optional.empty();
    }

    @Override
    public void delete(Integer id) {
        insurancePaymentRepository.deleteById(id);
    }

    @Override
    public Optional<InsurancePayment> updateWithCheck(Integer id, InsurancePaymentUpdateDto insurancePaymentUpdateDto) {
        Optional<InsurancePayment> insurancePaymentOptional = insurancePaymentRepository.findById(id);
        if (insurancePaymentOptional.isPresent() && insurancePaymentUpdateDto != null) {
            InsurancePayment insurancePayment = insurancePaymentOptional.get();
            if (insurancePaymentUpdateDto.getInsurancePaymentAmount() != null) {
                insurancePayment.setInsurancePaymentAmount(insurancePaymentUpdateDto.getInsurancePaymentAmount());
            }
            if (insurancePaymentUpdateDto.getCoefficientId() != null) {
                insurancePayment.setCoefficientId(insurancePaymentUpdateDto.getCoefficientId());
            }
            insurancePaymentRepository.save(insurancePayment);
            return Optional.of(insurancePayment);
        }
        return Optional.empty();
    }

    @Override
    public Optional<InsurancePayment> getInsurancePaymentById(Integer id) {
        return insurancePaymentRepository.findById(id);
    }




}


