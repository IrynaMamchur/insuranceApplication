package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.Coefficient;
import com.example.insuranceapplication.entity.dto.CoefficientDto;
import com.example.insuranceapplication.entity.updateDto.CoefficientUpdateDto;
import com.example.insuranceapplication.service.database.CoefficientDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CoefficientController {

    private final CoefficientDatabaseService coefficientDatabaseService;

    @GetMapping(value = "/coefficient/find/id/{id}")
    public ResponseEntity<Double> getCoefficientByID(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(coefficientDatabaseService.getCoefficientCoefficient(id));
    }

    @PostMapping(value = "/coefficient/create")
    public ResponseEntity<Coefficient> createCoefficient(@RequestBody Coefficient coefficient) {
        coefficientDatabaseService.create(coefficient);
        return ResponseEntity.ok(coefficient);
    }

    @PutMapping(value = "/coefficient/update/coefficientForCar")
    public ResponseEntity<Optional<Coefficient>> updateCoefficientForCar(@RequestBody CoefficientDto coefficientDto) {
        Optional<Coefficient> coefficient = coefficientDatabaseService.updateCoefficientForCar(coefficientDto);
        return ResponseEntity.ok(coefficient);
    }

    @PutMapping(value = "/coefficient/update/withCheck/{id}")
    public ResponseEntity<Optional<Coefficient>> updateWithCheck(@PathVariable(name = "id") Integer id, @RequestBody CoefficientUpdateDto coefficientUpdateDto) {
        Optional<Coefficient> coefficient = coefficientDatabaseService.updateWithCheck(id, coefficientUpdateDto);
        return ResponseEntity.ok(coefficient);
    }

    @DeleteMapping(value = "/coefficient/delete/{id}")
    public ResponseEntity<Integer> delete(@PathVariable Integer id) {
        coefficientDatabaseService.delete(id);
        return ResponseEntity.ok().build();
    }

    private ResponseEntity<List<Coefficient>> createResponseEntity(List<Coefficient> coefficients) {
        if (coefficients != null && !coefficients.isEmpty()) {
            return ResponseEntity.ok(coefficients);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
