package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.Coefficient;
import com.example.insuranceapplication.entity.enam.CarNumberOfPaymentsNumbers;

import java.util.Optional;

public interface CoefficientDatabaseService {

    double createCoefficient(String carBrandName, String carModelName, Double engineCapacity, String insuranceProgramName, Integer carFirstRegistr, CarNumberOfPaymentsNumbers number);

    double getCoefficient(Integer id);

}
