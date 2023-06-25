package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.car.CarInsuranceProgram;
import com.example.insuranceapplication.repository.CarInsuranceProgramRepository;
import com.example.insuranceapplication.service.database.CarInsuranceProgramDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarInsuranceProgramDatabaseServiceImpl implements CarInsuranceProgramDatabaseService {

    private final CarInsuranceProgramRepository carInsuranceProgramRepository;


    @Override
    public CarInsuranceProgram getInsuranceProgramByName(String insuranceProgramName) {
        return carInsuranceProgramRepository.getInsuranceProgramByInsuranceProgramName(insuranceProgramName);
    }

    @Override
    public Optional<CarInsuranceProgram> getInsuranceProgramById(int id) {
        return carInsuranceProgramRepository.findById(id);
    }

    @Override
    public List<CarInsuranceProgram> getAllInsuranceProgram() {
        return carInsuranceProgramRepository.findAll();
    }

    @Override
    public CarInsuranceProgram create(CarInsuranceProgram carInsuranceProgram) {
        return carInsuranceProgramRepository.save(new CarInsuranceProgram());
    }

    @Override
    public CarInsuranceProgram update(CarInsuranceProgram carInsuranceProgram) {
        return carInsuranceProgramRepository.save(carInsuranceProgram);
    }

    @Override
    public double getCoefficientCarInsuranceProgram(String insuranceProgramName) {
        return carInsuranceProgramRepository.getCoefficientCarInsuranceProgram(insuranceProgramName);
    }

}
