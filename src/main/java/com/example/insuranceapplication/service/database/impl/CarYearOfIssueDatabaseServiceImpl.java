package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.car.CarYearOfIssue;
import com.example.insuranceapplication.repository.CarYearOfIssueRepository;
import com.example.insuranceapplication.service.database.CarYearOfIssueDatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarYearOfIssueDatabaseServiceImpl implements CarYearOfIssueDatabaseService {

    private final CarYearOfIssueRepository carYearOfIssueRepository;


    @Override
    public CarYearOfIssue getYearOfIssueByCarFirstRegistr(Integer carFirstRegistr) {
        return carYearOfIssueRepository.getYearOfIssueByCarFirstRegistr(carFirstRegistr);
    }

    @Override
    public Optional<CarYearOfIssue> getCarYearOfIssueById(Integer id) {
        return carYearOfIssueRepository.findById(id);
    }

    @Override
    public List<CarYearOfIssue> getAllCarYearOfIssue() {
        return carYearOfIssueRepository.findAll();
    }

    @Override
    public CarYearOfIssue create(CarYearOfIssue carYearOfIssue) {
        return carYearOfIssueRepository.save(new CarYearOfIssue());
    }

    @Override
    public CarYearOfIssue update(CarYearOfIssue carYearOfIssue) {
        return carYearOfIssueRepository.save(carYearOfIssue);
    }

    @Override
    public double getCoefficientCarYearOfIssue(Integer carFirstRegistr) {
        return carYearOfIssueRepository.getCoefficientCarYearOfIssue(carFirstRegistr);
    }
}
