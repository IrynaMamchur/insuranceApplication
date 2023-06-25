package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.car.CarYearOfIssue;
import com.example.insuranceapplication.service.database.CarYearOfIssueDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CarYearOfIssueController {

    private final CarYearOfIssueDatabaseService carYearOfIssueDatabaseService;

    @GetMapping(value = "/carYearOfIssue/find/first_year/{carFirstRegistr}")
    public CarYearOfIssue getCarYearOfIssueByYear(@PathVariable(name = "carFirstRegistr") Integer carFirstRegistr) {
        CarYearOfIssue carYearOfIssue = carYearOfIssueDatabaseService.getYearOfIssueByCarFirstRegistr(carFirstRegistr);
        return carYearOfIssue;
    }

    @GetMapping(value = "/carYearOfIssue/find/id/{id}")
    public Optional<CarYearOfIssue> getCarEngineCapacityById(@PathVariable(name = "id") Integer id) {
        Optional<CarYearOfIssue> carYearOfIssue = carYearOfIssueDatabaseService.getCarYearOfIssueById(id);
        return carYearOfIssue;
    }

    @GetMapping(value = "/carYearOfIssue/find/all")
    public List<CarYearOfIssue> getAllCarEngineCapacity() {
        List<CarYearOfIssue> carYearOfIssues = carYearOfIssueDatabaseService.getAllCarYearOfIssue();
        return carYearOfIssues;
    }

    @GetMapping(value = "/carYearOfIssue/find/coefficient/{carFirstRegistr}")
    public double getCoefficientCarInsuranceProgram(@PathVariable(name = "carFirstRegistr") Integer carFirstRegistr) {
        return carYearOfIssueDatabaseService.getCoefficientCarYearOfIssue(carFirstRegistr);
    }

    @PostMapping(value = "/carYearOfIssue/create")
    public CarYearOfIssue createNewCarYearOfIssue(@RequestBody CarYearOfIssue carYearOfIssue) {
        carYearOfIssueDatabaseService.create(carYearOfIssue);
        return carYearOfIssue;
    }

    @PutMapping(value = "/carYearOfIssue/update")
    public CarYearOfIssue updateCarYearOfIssue(@RequestBody CarYearOfIssue carYearOfIssue) {
        carYearOfIssueDatabaseService.update(carYearOfIssue);
        return carYearOfIssue;
    }

}
