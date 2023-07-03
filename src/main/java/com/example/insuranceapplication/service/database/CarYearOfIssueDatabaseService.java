package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.car.CarEngineCapacity;
import com.example.insuranceapplication.entity.car.CarYearOfIssue;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CarYearOfIssueDatabaseService {

    CarYearOfIssue getYearOfIssueByCarFirstRegistr(Integer carFirstRegistr);

    Optional<CarYearOfIssue> getCarYearOfIssueById(Integer id);

    List<CarYearOfIssue> getAllCarYearOfIssue();

    CarYearOfIssue create(CarYearOfIssue carYearOfIssue);

    CarYearOfIssue update(CarYearOfIssue carYearOfIssue);

    double getCoefficientCarYearOfIssue (Integer carFirstRegistr);
}

