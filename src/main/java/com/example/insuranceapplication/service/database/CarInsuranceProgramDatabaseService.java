package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.car.CarBrand;
import com.example.insuranceapplication.entity.car.CarEngineCapacity;
import com.example.insuranceapplication.entity.car.CarInsuranceProgram;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CarInsuranceProgramDatabaseService {


    CarInsuranceProgram getInsuranceProgramByName(String insuranceProgramName);

    Optional<CarInsuranceProgram> getInsuranceProgramById(int id);

    List<CarInsuranceProgram> getAllInsuranceProgram();

    CarInsuranceProgram create(CarInsuranceProgram carInsuranceProgram);

    CarInsuranceProgram update(CarInsuranceProgram carInsuranceProgram);

    double getCoefficientCarInsuranceProgram (String insuranceProgramName);
}
