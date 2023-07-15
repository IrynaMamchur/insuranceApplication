package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.car.CarInsuranceProgram;
import com.example.insuranceapplication.entity.updateDto.CarInsuranceProgramUpdateDto;
import com.example.insuranceapplication.repository.carRepository.CarInsuranceProgramRepository;
import com.example.insuranceapplication.service.database.CarInsuranceProgramDatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
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
    public double getCoefficientCarInsuranceProgram(String insuranceProgramName) {
        return carInsuranceProgramRepository.getCoefficientCarInsuranceProgram(insuranceProgramName);
    }

    @Override
    public void delete(Integer id) {
        carInsuranceProgramRepository.deleteById(id);
    }

    @Override
    public Optional<CarInsuranceProgram> updateWithCheck(Integer id, CarInsuranceProgramUpdateDto carInsuranceProgramUpdateDto) {
        Optional<CarInsuranceProgram> carInsuranceProgramOptional = carInsuranceProgramRepository.findById(id);
        if (carInsuranceProgramOptional.isPresent() && carInsuranceProgramUpdateDto != null) {
            CarInsuranceProgram carInsuranceProgram = carInsuranceProgramOptional.get();
            if (carInsuranceProgramUpdateDto.getInsuranceProgramName() != null) {
                carInsuranceProgram.setInsuranceProgramName(carInsuranceProgramUpdateDto.getInsuranceProgramName());
            }
            if (carInsuranceProgramUpdateDto.getCoefficient() != null) {
                carInsuranceProgram.setCoefficient(carInsuranceProgramUpdateDto.getCoefficient());
            }
            carInsuranceProgramRepository.save(carInsuranceProgram);
            return Optional.of(carInsuranceProgram);
        }
        return Optional.empty();
    }

}
