package com.example.insuranceapplication.controller.carController;

import com.example.insuranceapplication.entity.car.CarYearOfIssue;
import com.example.insuranceapplication.entity.updateDto.CarYearOfIssueUpdateDto;
import com.example.insuranceapplication.service.database.CarYearOfIssueDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CarYearOfIssueController {

    private final CarYearOfIssueDatabaseService carYearOfIssueDatabaseService;

    @GetMapping(value = "/carYearOfIssue/find/firstYear/{carFirstRegistr}")
    public ResponseEntity<CarYearOfIssue> getCarYearOfIssueByYear(@PathVariable(name = "carFirstRegistr") Integer carFirstRegistr) {
        CarYearOfIssue carYearOfIssue = carYearOfIssueDatabaseService.getYearOfIssueByCarFirstRegistr(carFirstRegistr);
        return ResponseEntity.ok(carYearOfIssue);
    }

    @GetMapping(value = "/carYearOfIssue/find/id/{id}")
    public ResponseEntity<Optional<CarYearOfIssue>> getCarEngineCapacityById(@PathVariable(name = "id") Integer id) {
        Optional<CarYearOfIssue> carYearOfIssue = carYearOfIssueDatabaseService.getCarYearOfIssueById(id);
        return ResponseEntity.ok(carYearOfIssue);
    }

    @GetMapping(value = "/carYearOfIssue/find/all")
    public ResponseEntity<List<CarYearOfIssue>> getAllCarEngineCapacity() {
        List<CarYearOfIssue> carYearOfIssues = carYearOfIssueDatabaseService.getAllCarYearOfIssue();
        return createResponseEntity(carYearOfIssues);
    }

    @GetMapping(value = "/carYearOfIssue/find/coefficient/{carFirstRegistr}")
    public ResponseEntity<Double> getCoefficientCarInsuranceProgram(@PathVariable(name = "carFirstRegistr") Integer carFirstRegistr) {
        return ResponseEntity.ok(carYearOfIssueDatabaseService.getCoefficientCarYearOfIssue(carFirstRegistr));
    }

    @PostMapping(value = "/carYearOfIssue/create")
    public ResponseEntity<CarYearOfIssue> createNewCarYearOfIssue(@RequestBody CarYearOfIssue carYearOfIssue) {
        carYearOfIssueDatabaseService.create(carYearOfIssue);
        return ResponseEntity.ok(carYearOfIssue);
    }

    @PutMapping(value = "/carYearOfIssue/update/withCheck/{id}")
    public ResponseEntity<Optional<CarYearOfIssue>> updateWithCheck(@PathVariable(name = "id") Integer id, @RequestBody CarYearOfIssueUpdateDto carYearOfIssueUpdateDto) {
        Optional<CarYearOfIssue> carYearOfIssue = carYearOfIssueDatabaseService.updateWithCheck(id, carYearOfIssueUpdateDto);
        return ResponseEntity.ok(carYearOfIssue);
    }

    @DeleteMapping(value = "/carYearOfIssue/delete/{id}")
    public ResponseEntity<Integer> delete(@PathVariable Integer id) {
        carYearOfIssueDatabaseService.delete(id);
        return ResponseEntity.ok().build();
    }

    private ResponseEntity<List<CarYearOfIssue>> createResponseEntity(List<CarYearOfIssue> carYearOfIssues) {
        if (carYearOfIssues != null && !carYearOfIssues.isEmpty()) {
            return ResponseEntity.ok(carYearOfIssues);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
