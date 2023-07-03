package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.car.CarInsuranceProgram;
import com.example.insuranceapplication.service.database.CarInsuranceProgramDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CarInsuranceProgramController {

    private final CarInsuranceProgramDatabaseService carInsuranceProgramDatabaseService;

    @GetMapping(value = "/carInsuranceProgram/find/name/{insuranceProgramName}")
    public CarInsuranceProgram getCarInsuranceProgramByName(@PathVariable(name = "insuranceProgramName") String insuranceProgramName) {
        CarInsuranceProgram carInsuranceProgram = carInsuranceProgramDatabaseService.getInsuranceProgramByName(insuranceProgramName);
        return carInsuranceProgram;
    }

    @GetMapping(value = "/carInsuranceProgram/find/id/{id}")
    public Optional<CarInsuranceProgram> getCarInsuranceProgramById(@PathVariable(name = "id") Integer id) {
        Optional<CarInsuranceProgram> carInsuranceProgram = carInsuranceProgramDatabaseService.getInsuranceProgramById(id);
        return carInsuranceProgram;
    }

    @GetMapping(value = "/carInsuranceProgram/find/all")
    public List<CarInsuranceProgram> getAllCarInsuranceProgram() {
        List<CarInsuranceProgram> carInsurancePrograms = carInsuranceProgramDatabaseService.getAllInsuranceProgram();
        return carInsurancePrograms;
    }

    @GetMapping(value = "/carInsuranceProgram/find/coefficient/{insuranceProgramName}")
    public double getCoefficientCarInsuranceProgram(@PathVariable(name = "insuranceProgramName") String insuranceProgramName) {
        return carInsuranceProgramDatabaseService.getCoefficientCarInsuranceProgram(insuranceProgramName);
    }

    @PostMapping(value = "/carInsuranceProgram/create")
    public CarInsuranceProgram createNewCarInsuranceProgram(@RequestBody CarInsuranceProgram carInsuranceProgram) {
        carInsuranceProgramDatabaseService.create(carInsuranceProgram);
        return carInsuranceProgram;
    }

    @PutMapping(value = "/carInsuranceProgram/update")
    public CarInsuranceProgram updateInsuranceProgram(@RequestBody CarInsuranceProgram carInsuranceProgram) {
        carInsuranceProgramDatabaseService.update(carInsuranceProgram);
        return carInsuranceProgram;
    }
}
