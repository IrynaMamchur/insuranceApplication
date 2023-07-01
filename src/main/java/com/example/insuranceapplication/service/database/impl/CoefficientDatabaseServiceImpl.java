package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.Coefficient;
import com.example.insuranceapplication.entity.enam.CarQuantityOfPaymentsNumbers;
import com.example.insuranceapplication.repository.CoefficientRepository;
import com.example.insuranceapplication.service.database.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CoefficientDatabaseServiceImpl implements CoefficientDatabaseService {

    private final CoefficientRepository coefficientRepository;
    private final CarBrandDatabaseService carBrandDatabaseService;
    private final CarEngineCapacityDatabaseService carEngineCapacityDatabaseService;
    private final CarInsuranceProgramDatabaseService carInsuranceProgramDatabaseService;
    private final CarYearOfIssueDatabaseService carYearOfIssueDatabaseService;
    private final CarQuantityOfPaymentsDatabaseService carQuantityOfPaymentsDatabaseService;


//    public double createCoefficient(String carBrandName, Double engineCapacity, String insuranceProgramName, Integer carFirstRegistr, CarQuantityOfPaymentsNumbers number) {
//        Double coefCarBrand;
//        Double coefCarEngineCapacity;
//        Double coefCarInsuranceProgram;
//        Double coefCarYearOfIssue;
//        Double coefCarQuantityOfPayments;
//        double coefficientForCar;
//
//        coefCarBrand = carBrandDatabaseService.getCoefficientCarBrand(carBrandName);
//        coefCarEngineCapacity = carEngineCapacityDatabaseService.getCoefficientCarEngineCapacity(engineCapacity);
//        coefCarInsuranceProgram = carInsuranceProgramDatabaseService.getCoefficientCarInsuranceProgram(insuranceProgramName);
//        coefCarYearOfIssue = carYearOfIssueDatabaseService.getCoefficientCarYearOfIssue(carFirstRegistr);
//        coefCarQuantityOfPayments = carQuantityOfPaymentsDatabaseService.getCoefficientCarNumberOfPayments(number);
//        coefficientRepository.createNewCoefficient(coefCarBrand, coefCarEngineCapacity, coefCarInsuranceProgram, coefCarYearOfIssue, coefCarQuantityOfPayments);
//        {
//            coefficientForCar = coefCarBrand * coefCarEngineCapacity * coefCarInsuranceProgram * coefCarYearOfIssue * coefCarQuantityOfPayments;
//        }
//        return coefficientForCar;
//    }

    @Override
    public double getCoefficient(Integer id) {
        return coefficientRepository.getCoefficient(id);
    }

    @Override
    public Coefficient create(Coefficient coefficient) {
        return coefficientRepository.save(coefficient);
    }

}
