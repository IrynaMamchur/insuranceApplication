package com.example.insuranceapplication.controller.carController;

import com.example.insuranceapplication.entity.car.CarEngineCapacity;
import com.example.insuranceapplication.entity.updateDto.CarEngineCapacityUpdateDto;
import com.example.insuranceapplication.service.database.CarEngineCapacityDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CarEngineCapacityController {

    private final CarEngineCapacityDatabaseService carEngineCapacityDatabaseService;

    @GetMapping(value = "/carEngineCapacity/find/engineCapacity/{engineCapacity}")
    public ResponseEntity<CarEngineCapacity> getCarEngineCapacity(@PathVariable(name = "engineCapacity") Double engineCapacity) {
        CarEngineCapacity carEngineCapacity = carEngineCapacityDatabaseService.getEngineCapacity(engineCapacity);
        return ResponseEntity.ok(carEngineCapacity);
    }

    @GetMapping(value = "/carEngineCapacity/find/id/{id}")
    public ResponseEntity<Optional<CarEngineCapacity>> getCarEngineCapacityById(@PathVariable(name = "id") Integer id) {
        Optional<CarEngineCapacity> carEngineCapacity = carEngineCapacityDatabaseService.getCarEngineCapacityById(id);
        return ResponseEntity.ok(carEngineCapacity);
    }

    @GetMapping(value = "/carEngineCapacity/find/all")
    public ResponseEntity<List<CarEngineCapacity>> getAllCarEngineCapacity() {
        List<CarEngineCapacity> carEngineCapacities = carEngineCapacityDatabaseService.getAllCarEngineCapacity();
        return createResponseEntity(carEngineCapacities);
    }

    @GetMapping(value = "/carEngineCapacity/find/coefficient/{engineCapacity}")
    public ResponseEntity<Double> getCoefficientCarEngineCapacity(@PathVariable(name = "engineCapacity") Double engineCapacity) {
        return ResponseEntity.ok(carEngineCapacityDatabaseService.getCoefficientCarEngineCapacity(engineCapacity));
    }

    @PostMapping(value = "/carEngineCapacity/create")
    public ResponseEntity<CarEngineCapacity> createNewCarEngineCapacity(@RequestBody CarEngineCapacity carEngineCapacity) {
        carEngineCapacityDatabaseService.create(carEngineCapacity);
        return ResponseEntity.ok(carEngineCapacity);
    }

    @PutMapping(value = "/carEngineCapacity/update")
    public ResponseEntity<CarEngineCapacity> updateCarBrand(@RequestBody CarEngineCapacity carEngineCapacity) {
        carEngineCapacityDatabaseService.update(carEngineCapacity);
        return ResponseEntity.ok(carEngineCapacity);
    }

    @PutMapping(value = "/carEngineCapacity/update/withCheck/{id}")
    public ResponseEntity<Optional<CarEngineCapacity>> updateWithCheck(@PathVariable(name = "id") Integer id, @RequestBody CarEngineCapacityUpdateDto carEngineCapacityUpdateDto) {
        Optional<CarEngineCapacity> carEngineCapacity = carEngineCapacityDatabaseService.updateWithCheck(id, carEngineCapacityUpdateDto);
        return ResponseEntity.ok(carEngineCapacity);
    }

    @DeleteMapping(value = "/carEngineCapacity/delete/{id}")
    public ResponseEntity<Integer> delete(@PathVariable Integer id) {
        carEngineCapacityDatabaseService.delete(id);
        return ResponseEntity.ok().build();
    }

    private ResponseEntity<List<CarEngineCapacity>> createResponseEntity(List<CarEngineCapacity> carEngineCapacities) {
        if (carEngineCapacities != null && !carEngineCapacities.isEmpty()) {
            return ResponseEntity.ok(carEngineCapacities);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
