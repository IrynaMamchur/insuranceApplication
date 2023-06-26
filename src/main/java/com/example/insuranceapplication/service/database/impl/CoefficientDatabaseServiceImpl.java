package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.Coefficient;
import com.example.insuranceapplication.entity.enam.CarNumberOfPaymentsNumbers;
import com.example.insuranceapplication.repository.CoefficientRepository;
import com.example.insuranceapplication.service.database.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoefficientDatabaseServiceImpl implements CoefficientDatabaseService {

    private final CoefficientRepository coefficientRepository;
    private final CarBrandDatabaseService carBrandDatabaseService;
    private final CarEngineCapacityDatabaseService carEngineCapacityDatabaseService;
    private final CarInsuranceProgramDatabaseService carInsuranceProgramDatabaseService;
    private final CarYearOfIssueDatabaseService carYearOfIssueDatabaseService;
    private final CarNumberOfPaymentsDatabaseService carNumberOfPaymentsDatabaseService;
    public Double coefFirst;
    public Double coefSecond;
    public Double coefThird;
    public Double coefFor;
    public Double coefFives;
    public Double coefNew;


    public double createCoefficient(String carBrandName, String carModelName, Double engineCapacity, String insuranceProgramName, Integer carFirstRegistr, CarNumberOfPaymentsNumbers number) {
        coefFirst = carBrandDatabaseService.getCoefficientCarBrand(carBrandName, carModelName);
        coefSecond = carEngineCapacityDatabaseService.getCoefficientCarEngineCapacity(engineCapacity);
        coefThird = carInsuranceProgramDatabaseService.getCoefficientCarInsuranceProgram(insuranceProgramName);
        coefFor = carYearOfIssueDatabaseService.getCoefficientCarYearOfIssue(carFirstRegistr);
        coefFives = carNumberOfPaymentsDatabaseService.getCoefficientCarNumberOfPayments(number);
        coefficientRepository.createCoefficient(coefFirst, coefSecond, coefThird, coefFor, coefFives);
        {
            coefNew = coefFirst * coefSecond * coefThird * coefFor * coefFives;
        }
        return coefNew;
    }

    @Override
    public double getCoefficient(Integer id) {
        return coefficientRepository.getCoefficient(id);
    }

}
