package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.car.CarEngineCapacity;
import com.example.insuranceapplication.service.database.CarEngineCapacityDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CarEngineCapacityController {

    private final CarEngineCapacityDatabaseService carEngineCapacityDatabaseService;

    @GetMapping(value = "/carEngineCapacity/find/engineCapacity/{engineCapacity}")
    public CarEngineCapacity getCarEngineCapacity(@PathVariable(name = "engineCapacity") Double engineCapacity) {
        CarEngineCapacity carEngineCapacity = carEngineCapacityDatabaseService.getCarEngineCapacity(engineCapacity);
        return carEngineCapacity;
    }

    @GetMapping(value = "/carEngineCapacity/find/id/{id}")
    public Optional<CarEngineCapacity> getCarEngineCapacityById(@PathVariable(name = "id") Integer id) {
        Optional<CarEngineCapacity> carEngineCapacity = carEngineCapacityDatabaseService.getCarEngineCapacityById(id);
        return carEngineCapacity;
    }

    @GetMapping(value = "/carEngineCapacity/find/all")
    public List<CarEngineCapacity> getAllCarEngineCapacity() {
        List<CarEngineCapacity> carEngineCapacities = carEngineCapacityDatabaseService.getAllCarEngineCapacity();
        return carEngineCapacities;
    }

    @PostMapping(value = "/carEngineCapacity/create")
    public CarEngineCapacity createNewCarEngineCapacity(@RequestBody CarEngineCapacity carEngineCapacity) {
        carEngineCapacityDatabaseService.create(carEngineCapacity);
        return carEngineCapacity;
    }

    @PutMapping(value = "/carEngineCapacity/update")
    public CarEngineCapacity updateCarBrand(@RequestBody CarEngineCapacity carEngineCapacity) {
        carEngineCapacityDatabaseService.update(carEngineCapacity);
        return carEngineCapacity;
    }
}
