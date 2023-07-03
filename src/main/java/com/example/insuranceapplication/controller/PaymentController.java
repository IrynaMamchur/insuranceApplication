package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.InsurancePayment;
import com.example.insuranceapplication.entity.Payment;
import com.example.insuranceapplication.service.database.PaymentDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentDatabaseService paymentDatabaseService;

//    @GetMapping(value = "/payment/find/contractNumberId/{contractNumberId}")
//    public ResponseEntity <List<Payment>> getPaymentsByContractNumberId(@PathVariable(name = "contractNumberId") Integer contractNumberId) {
//        List<Payment> payments = paymentDatabaseService.getPaymentsByContractNumberId(contractNumberId);
//        return createResponseEntity(payments);
//    }

    @GetMapping(value = "/payment/find/amount/{amount}")
    public ResponseEntity <List<Payment>>getPaymentsByAmount(@PathVariable(name = "amount") Integer amount) {
        List<Payment> payments = paymentDatabaseService.getPaymentsByAmount(amount);
        return createResponseEntity(payments);
    }


    @GetMapping(value = "/payment/find/all")
    public ResponseEntity <List<Payment>> getAllPayments() {
        List<Payment> payments = paymentDatabaseService.getAllPayments();
        return createResponseEntity(payments);
    }

    @GetMapping(value = "/payment/find/id/{id}")
    public ResponseEntity <Optional<Payment>> getPaymentById(@PathVariable(name = "id") Integer id) {
        Optional<Payment> payment = paymentDatabaseService.getPaymentById(id);
        return ResponseEntity.ok(payment);
    }

    @PostMapping(value = "/payment/create")
    public ResponseEntity <Payment> createNewPayment(@RequestBody Payment payment) {
        paymentDatabaseService.create(payment);
        return ResponseEntity.ok(payment);
    }

    @PutMapping(value = "/payment/update")
    public ResponseEntity <Payment> updatePayment(@RequestBody Payment payment) {
        paymentDatabaseService.update(payment);
        return ResponseEntity.ok(payment);
    }

    private ResponseEntity<List<Payment>> createResponseEntity(List<Payment> payments) {
        if (payments != null && !payments.isEmpty()) {
            return ResponseEntity.ok(payments);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
