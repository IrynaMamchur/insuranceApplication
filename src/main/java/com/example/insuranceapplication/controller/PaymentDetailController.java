package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.entity.InsurancePayment;
import com.example.insuranceapplication.entity.Payment;
import com.example.insuranceapplication.entity.PaymentDetail;
import com.example.insuranceapplication.service.database.PaymentDetailDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PaymentDetailController {

    private final PaymentDetailDatabaseService paymentDetailDatabaseService;


    @GetMapping(value = "/paymentDetail/find/all")
    public ResponseEntity<List<PaymentDetail>> getAllPaymentDetails() {
        List<PaymentDetail> paymentDetails = paymentDetailDatabaseService.getAllPaymentDetails();
        return createResponseEntity(paymentDetails);
    }

    @GetMapping(value = "/paymentDetail/find/id/{id}")
    public ResponseEntity<Optional<PaymentDetail>> getPaymentDetailById(@PathVariable(name = "id") Integer id) {
        Optional<PaymentDetail> paymentDetail = paymentDetailDatabaseService.getPaymentDetailById(id);
        return ResponseEntity.ok(paymentDetail);
    }

    @PostMapping(value = "/paymentDetail/create")
    public ResponseEntity<PaymentDetail> createNewPaymentDetail(@RequestBody PaymentDetail paymentDetail) {
        paymentDetailDatabaseService.create(paymentDetail);
        return ResponseEntity.ok(paymentDetail);
    }

    @PutMapping(value = "/paymentDetail/update")
    public ResponseEntity<PaymentDetail> updatePaymentDetail(@RequestBody PaymentDetail paymentDetail) {
        paymentDetailDatabaseService.update(paymentDetail);
        return ResponseEntity.ok(paymentDetail);
    }

    @PutMapping(value = "/paymentDetail/update/payment")
    public ResponseEntity<Optional<PaymentDetail>> updatePayment(@RequestBody Integer id, Integer payment1, Integer payment2) {
        Optional<PaymentDetail> paymentDetail = paymentDetailDatabaseService.updatePayment(id, payment1, payment2);
        return ResponseEntity.ok(paymentDetail);
    }

    private ResponseEntity<List<PaymentDetail>> createResponseEntity(List<PaymentDetail> paymentDetails) {
        if (paymentDetails != null && !paymentDetails.isEmpty()) {
            return ResponseEntity.ok(paymentDetails);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}

