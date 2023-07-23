package com.example.insuranceapplication.controller.carController;

import com.example.insuranceapplication.entity.car.CarBrand;
import com.example.insuranceapplication.entity.car.CarQuantityOfPayments;
import com.example.insuranceapplication.entity.updateDto.CarQuantityOfPaymentUpdateDto;
import com.example.insuranceapplication.service.database.CarQuantityOfPaymentsDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CarQuantityOfPaymentsController {

    private final CarQuantityOfPaymentsDatabaseService carQuantityOfPaymentsDatabaseService;

    @GetMapping(value = "/carQuantityOfPayments/find/coefficient/{number}")
    public ResponseEntity<Double> getCoefficientCarNumberOfPayments(@PathVariable(name = "number") Integer number) {
        return ResponseEntity.ok(carQuantityOfPaymentsDatabaseService.getCoefficientCarNumberOfPayments(number));
    }

    @PostMapping(value = "/carQuantityOfPayments/create")
    public ResponseEntity<CarQuantityOfPayments> create(@RequestBody CarQuantityOfPayments carQuantityOfPayments) {
        carQuantityOfPaymentsDatabaseService.create(carQuantityOfPayments);
        return ResponseEntity.ok(carQuantityOfPayments);
    }
    @GetMapping(value = "/carQuantityOfPayments/find/all")
    public ResponseEntity<List<CarQuantityOfPayments>> getAllCarQuantityOfPayments() {
        List<CarQuantityOfPayments> carQuantityOfPayments = carQuantityOfPaymentsDatabaseService.getAllCarQuantityOfPayments();
        return createResponseEntity(carQuantityOfPayments);
    }

    @GetMapping(value = "/carQuantityOfPayments/find/id/{id}")
    public ResponseEntity <Optional<CarQuantityOfPayments>> getCarQuantityOfPaymentsById(@PathVariable(name = "id") Integer id) {
        Optional<CarQuantityOfPayments>carQuantityOfPayments = carQuantityOfPaymentsDatabaseService.getCarQuantityOfPaymentsByID(id);
        return ResponseEntity.ok(carQuantityOfPayments);
    }

    @PutMapping(value = "/carQuantityOfPayments/update/withCheck/{id}")
    public ResponseEntity<Optional<CarQuantityOfPayments>> updateWithCheck(@PathVariable(name = "id") Integer id, @RequestBody CarQuantityOfPaymentUpdateDto carQuantityOfPaymentUpdateDto) {
        Optional<CarQuantityOfPayments> carQuantityOfPayments = carQuantityOfPaymentsDatabaseService.updateWithCheck(id, carQuantityOfPaymentUpdateDto);
        return ResponseEntity.ok(carQuantityOfPayments);
    }

    @DeleteMapping(value = "/carQuantityOfPayments/delete/{id}")
    public ResponseEntity<Integer> delete(@PathVariable Integer id) {
        carQuantityOfPaymentsDatabaseService.delete(id);
        return ResponseEntity.ok().build();
    }


    private ResponseEntity<List<CarQuantityOfPayments>> createResponseEntity(List<CarQuantityOfPayments> carQuantityOfPayments) {
        if (carQuantityOfPayments != null && !carQuantityOfPayments.isEmpty()) {
            return ResponseEntity.ok(carQuantityOfPayments);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
