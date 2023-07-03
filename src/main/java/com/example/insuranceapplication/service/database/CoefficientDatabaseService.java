package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.ClientRequests;
import com.example.insuranceapplication.entity.Coefficient;
import com.example.insuranceapplication.entity.enam.CarQuantityOfPaymentsNumbers;

public interface CoefficientDatabaseService {

    double createCoefficient(String carBrandName, Double engineCapacity, String insuranceProgramName, Integer carFirstRegistr, CarQuantityOfPaymentsNumbers number);

    double getCoefficient(Integer id);

    Coefficient create(Coefficient coefficient);
}
