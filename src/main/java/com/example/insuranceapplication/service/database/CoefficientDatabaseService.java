package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.Coefficient;
import com.example.insuranceapplication.entity.dto.CoefficientDto;
import com.example.insuranceapplication.entity.updateDto.CoefficientUpdateDto;

import java.util.Optional;

public interface CoefficientDatabaseService {

    double createCoefficient(String carBrandName, Double engineCapacity, String insuranceProgramName, Integer carFirstRegistr, Integer number);

    double getCoefficientCoefficient(Integer id);

    Coefficient create(Coefficient coefficient);

    Optional<Coefficient> updateCoefficientForCar(CoefficientDto coefficientDto);

    void delete(Integer id);

    Optional<Coefficient> updateWithCheck(Integer id, CoefficientUpdateDto coefficientUpdateDto);
}
