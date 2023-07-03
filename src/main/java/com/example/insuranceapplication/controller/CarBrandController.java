package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.car.CarBrand;
import com.example.insuranceapplication.service.database.CarBrandDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CarBrandController {

    private final CarBrandDatabaseService carBrandDatabaseService;

    @GetMapping(value = "/carBrand/find/name/{carBrandName}/{carModelName}")
    public CarBrand getCarBrandByName(@PathVariable(name = "carBrandName") String carBrandName, @PathVariable(name = "carModelName") String carModelName) {
        CarBrand carBrand = carBrandDatabaseService.getCarBrandByName(carBrandName, carModelName);
        return carBrand;
    }

    @GetMapping(value = "/carBrand/find/id/{id}")
    public Optional<CarBrand> getCarBrandById(@PathVariable(name = "id") Integer id) {
        Optional<CarBrand> carBrand = carBrandDatabaseService.getCarBrandById(id);
        return carBrand;
    }

    @GetMapping(value = "/carBrand/find/all-of-brand-name/{carBrandName}")
    public List<CarBrand> getCarBrandsByCarBrandName(@PathVariable(name = "carBrandName") String carBrandName) {
        List<CarBrand> carBrands = carBrandDatabaseService.getCarBrandByCarBrandName(carBrandName);
        return carBrands;
    }

    @GetMapping(value = "/carBrand/find/all")
    public List<CarBrand> getCarBrands() {
        List<CarBrand> carBrands = carBrandDatabaseService.getCarBrands();
        return carBrands;
    }

    @PostMapping(value = "/carBrand/create")
    public CarBrand createNewCarBrand(@RequestBody CarBrand carBrand) {
        carBrandDatabaseService.create(carBrand);
        return carBrand;
    }

    @PutMapping(value = "/carBrand/update")
    public CarBrand updateCarBrand(@RequestBody CarBrand carBrand) {
        carBrandDatabaseService.update(carBrand);
        return carBrand;
    }
}
