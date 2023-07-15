package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.Coefficient;
import com.example.insuranceapplication.entity.dto.CoefficientDto;
import com.example.insuranceapplication.entity.enam.CarQuantityOfPaymentsNumbers;
import com.example.insuranceapplication.entity.updateDto.CoefficientUpdateDto;
import com.example.insuranceapplication.repository.CoefficientRepository;
import com.example.insuranceapplication.service.database.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

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


    public double createCoefficient(String carBrandName, Double engineCapacity, String insuranceProgramName, Integer carFirstRegistr, CarQuantityOfPaymentsNumbers number) {
        double coefCarBrand;
        double coefCarEngineCapacity;
        double coefCarInsuranceProgram;
        double coefCarYearOfIssue;
        double coefCarQuantityOfPayments;
        double coefficientForCar;

        coefCarBrand = carBrandDatabaseService.getCoefficientCarBrand(carBrandName);
        coefCarEngineCapacity = carEngineCapacityDatabaseService.getCoefficientCarEngineCapacity(engineCapacity);
        coefCarInsuranceProgram = carInsuranceProgramDatabaseService.getCoefficientCarInsuranceProgram(insuranceProgramName);
        coefCarYearOfIssue = carYearOfIssueDatabaseService.getCoefficientCarYearOfIssue(carFirstRegistr);
        coefCarQuantityOfPayments = carQuantityOfPaymentsDatabaseService.getCoefficientCarNumberOfPayments(String.valueOf(number));
        if (coefCarBrand <= 0 || coefCarEngineCapacity <= 0 || coefCarInsuranceProgram <= 0 || coefCarYearOfIssue <= 0 || coefCarQuantityOfPayments <= 0) {
            throw new IllegalArgumentException();
        }
        coefficientForCar = coefCarBrand * coefCarEngineCapacity * coefCarInsuranceProgram * coefCarYearOfIssue * coefCarQuantityOfPayments;
        return coefficientForCar;
    }

    @Override
    public double getCoefficient(Integer id) {
        return coefficientRepository.getCoefficient(id);
    }

    @Override
    public Coefficient create(Coefficient coefficient) {
        return coefficientRepository.save(coefficient);
    }

    @Override
    public Optional<Coefficient> updateCoefficientForCar(CoefficientDto coefficientDto) {
        Integer id = coefficientDto.getId();
        String carBrandName = coefficientDto.getCarBrandName();
        Double engineCapacity = coefficientDto.getEngineCapacity();
        String insuranceProgramName = coefficientDto.getInsuranceProgramName();
        Integer carFirstRegistr = coefficientDto.getCarFirstRegistr();
        CarQuantityOfPaymentsNumbers number = CarQuantityOfPaymentsNumbers.valueOf(coefficientDto.getNumber());
        Optional<Coefficient> coefficientOptional = coefficientRepository.findById(id);
        if (coefficientOptional.isPresent()) {
            Coefficient coefficient = coefficientOptional.get();
            coefficient.setCoefficientForCar(createCoefficient(carBrandName, engineCapacity, insuranceProgramName, carFirstRegistr, number));
            coefficientRepository.save(coefficient);
            return Optional.of(coefficient);
        }
        return Optional.empty();
    }

    @Override
    public void delete(Integer id) {
        coefficientRepository.deleteById(id);
    }

    @Override
    public Optional<Coefficient> updateWithCheck(Integer id, CoefficientUpdateDto coefficientUpdateDto) {
        Optional<Coefficient> coefficientOptional = coefficientRepository.findById(id);
        if (coefficientOptional.isPresent() && coefficientUpdateDto != null) {
            Coefficient coefficient = coefficientOptional.get();
            if (coefficientUpdateDto.getCarBrand() != null) {
                coefficient.setCarBrand(coefficientUpdateDto.getCarBrand());
            }
            if (coefficientUpdateDto.getCarEngineCapacity() != null) {
                coefficient.setCarEngineCapacity(coefficientUpdateDto.getCarEngineCapacity());
            }
            if (coefficientUpdateDto.getCarInsuranceProgram() != null) {
                coefficient.setCarInsuranceProgram(coefficientUpdateDto.getCarInsuranceProgram());
            }
            if (coefficientUpdateDto.getCarYearOfIssue() != null) {
                coefficient.setCarYearOfIssue(coefficientUpdateDto.getCarYearOfIssue());
            }
            if (coefficientUpdateDto.getCoefficientForCar() != null) {
                coefficient.setCoefficientForCar(coefficientUpdateDto.getCoefficientForCar());
            }
            if (coefficientUpdateDto.getCarQuantityOfPayments() != null) {
                coefficient.setCarQuantityOfPayments(coefficientUpdateDto.getCarQuantityOfPayments());
            }

            coefficientRepository.save(coefficient);
            return Optional.of(coefficient);
        }
        return Optional.empty();
    }

}
