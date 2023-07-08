package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.Coefficient;
import com.example.insuranceapplication.entity.dto.CoefficientDto;
import com.example.insuranceapplication.entity.enam.CarQuantityOfPaymentsNumbers;

import java.util.Optional;

public interface CoefficientDatabaseService {

    double createCoefficient(String carBrandName, Double engineCapacity, String insuranceProgramName, Integer carFirstRegistr, CarQuantityOfPaymentsNumbers number);

    double getCoefficient(Integer id);

    Coefficient create(Coefficient coefficient);

    Optional<Coefficient> updateCoefficientForCar(CoefficientDto coefficientDto);
}
