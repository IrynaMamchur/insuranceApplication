package com.example.insuranceapplication.controller.carController;

import com.example.insuranceapplication.entity.car.CarBrand;
import com.example.insuranceapplication.entity.updateDto.CarBrandUpdateDto;
import com.example.insuranceapplication.service.database.CarBrandDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CarBrandController {

    private final CarBrandDatabaseService carBrandDatabaseService;

    @GetMapping(value = "/carBrand/find/name/{carBrandName}")
    public ResponseEntity<CarBrand> getCarBrandByName(@PathVariable(name = "carBrandName") String carBrandName) {
        CarBrand carBrand = carBrandDatabaseService.getCarBrandByName(carBrandName);
        return ResponseEntity.ok(carBrand);
    }

    @GetMapping(value = "/carBrand/find/id/{id}")
    public ResponseEntity <Optional<CarBrand>> getCarBrandById(@PathVariable(name = "id") Integer id) {
        Optional<CarBrand>carBrand = carBrandDatabaseService.getCarBrandById(id);
        return ResponseEntity.ok(carBrand);
    }


    @GetMapping(value = "/carBrand/find/coefficient/{carBrandName}")
    public ResponseEntity<Double> getCoefficientCarBrand(@PathVariable(name = "carBrandName") String carBrandName) {
        return ResponseEntity.ok(carBrandDatabaseService.getCoefficientCarBrand(carBrandName));
    }


    @GetMapping(value = "/carBrand/find/all")
    public ResponseEntity<List<CarBrand>> getCarBrands() {
        List<CarBrand> carBrands = carBrandDatabaseService.getCarBrands();
        return createResponseEntity(carBrands);
    }


    @PostMapping(value = "/carBrand/create")
    public ResponseEntity<CarBrand> createNewCarBrand(@RequestBody CarBrand carBrand) {
        carBrandDatabaseService.create(carBrand);
        return ResponseEntity.ok(carBrand);
    }

    @PutMapping(value = "/carBrand/update/withCheck/{id}")
    public ResponseEntity<Optional<CarBrand>> updateWithCheck(@PathVariable(name = "id") Integer id, @RequestBody CarBrandUpdateDto carBrandUpdateDto) {
        Optional<CarBrand> carBrand = carBrandDatabaseService.updateWithCheck(id, carBrandUpdateDto);
        return ResponseEntity.ok(carBrand);
    }

    @DeleteMapping(value = "/carBrand/delete/{id}")
    public ResponseEntity<Integer> deleteCarBrand(@PathVariable Integer id) {
        carBrandDatabaseService.delete(id);
        return ResponseEntity.ok().build();
    }


    private ResponseEntity<List<CarBrand>> createResponseEntity(List<CarBrand> carBrands) {
        if (carBrands != null && !carBrands.isEmpty()) {
            return ResponseEntity.ok(carBrands);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
