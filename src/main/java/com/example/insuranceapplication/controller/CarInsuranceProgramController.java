package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.car.CarEngineCapacity;
import com.example.insuranceapplication.entity.car.CarInsuranceProgram;
import com.example.insuranceapplication.service.database.CarInsuranceProgramDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CarInsuranceProgramController {

    private final CarInsuranceProgramDatabaseService carInsuranceProgramDatabaseService;

    @GetMapping(value = "/carInsuranceProgram/find/name/{insuranceProgramName}")
    public ResponseEntity <CarInsuranceProgram> getCarInsuranceProgramByName(@PathVariable(name = "insuranceProgramName") String insuranceProgramName) {
        CarInsuranceProgram carInsuranceProgram = carInsuranceProgramDatabaseService.getInsuranceProgramByName(insuranceProgramName);
        return ResponseEntity.ok(carInsuranceProgram);
    }

    @GetMapping(value = "/carInsuranceProgram/find/id/{id}")
    public ResponseEntity <Optional<CarInsuranceProgram>> getCarInsuranceProgramById(@PathVariable(name = "id") Integer id) {
        Optional<CarInsuranceProgram> carInsuranceProgram = carInsuranceProgramDatabaseService.getInsuranceProgramById(id);
        return ResponseEntity.ok(carInsuranceProgram);
    }

    @GetMapping(value = "/carInsuranceProgram/find/all")
    public ResponseEntity <List<CarInsuranceProgram>> getAllCarInsuranceProgram() {
        List<CarInsuranceProgram> carInsurancePrograms = carInsuranceProgramDatabaseService.getAllInsuranceProgram();
        return createResponseEntity(carInsurancePrograms);
    }

    @GetMapping(value = "/carInsuranceProgram/find/coefficient/{insuranceProgramName}")
    public ResponseEntity <Double> getCoefficientCarInsuranceProgram(@PathVariable(name = "insuranceProgramName") String insuranceProgramName) {
        return ResponseEntity.ok(carInsuranceProgramDatabaseService.getCoefficientCarInsuranceProgram(insuranceProgramName));
    }

    @PostMapping(value = "/carInsuranceProgram/create")
    public ResponseEntity <CarInsuranceProgram> createNewCarInsuranceProgram(@RequestBody CarInsuranceProgram carInsuranceProgram) {
        carInsuranceProgramDatabaseService.create(carInsuranceProgram);
        return ResponseEntity.ok(carInsuranceProgram);
    }

    @PutMapping(value = "/carInsuranceProgram/update")
    public ResponseEntity <CarInsuranceProgram> updateInsuranceProgram(@RequestBody CarInsuranceProgram carInsuranceProgram) {
        carInsuranceProgramDatabaseService.update(carInsuranceProgram);
        return ResponseEntity.ok(carInsuranceProgram);
    }

    private ResponseEntity<List<CarInsuranceProgram>> createResponseEntity(List<CarInsuranceProgram> carInsurancePrograms) {
        if (carInsurancePrograms != null && !carInsurancePrograms.isEmpty()) {
            return ResponseEntity.ok(carInsurancePrograms);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
