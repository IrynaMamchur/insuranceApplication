package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.entity.Payment;
import com.example.insuranceapplication.entity.PaymentDetail;
import com.example.insuranceapplication.service.database.PaymentDetailDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PaymentDetailController {

    private final PaymentDetailDatabaseService paymentDetailDatabaseService;

    @GetMapping(value = "/paymentDetail/find/amount_all/{amountAll}")
    public List<PaymentDetail> getPaymentDetailByAmountAll(@PathVariable(name = "amountAll") Double amountAll) {
        List<PaymentDetail> paymentDetails = paymentDetailDatabaseService.getPaymentDetailByAmountAll(amountAll);
        return paymentDetails;
    }

    @GetMapping(value = "/paymentDetail/find/all")
    public List<PaymentDetail> getAllPaymentDetails() {
        List<PaymentDetail> paymentDetails = paymentDetailDatabaseService.getAllPaymentDetails();
        return paymentDetails;
    }

    @GetMapping(value = "/paymentDetail/find/id/{id}")
    public Optional<PaymentDetail> getPaymentDetailById(@PathVariable(name = "id") Integer id) {
        Optional<PaymentDetail> paymentDetail = paymentDetailDatabaseService.getPaymentDetailById(id);
        return paymentDetail;
    }

    @PostMapping(value = "/paymentDetail/create")
    public PaymentDetail createNewPaymentDetail(@RequestBody PaymentDetail paymentDetail) {
        paymentDetailDatabaseService.create(paymentDetail);
        return paymentDetail;
    }

    @PutMapping(value = "/paymentDetail/update")
    public PaymentDetail updatePaymentDetail(@RequestBody PaymentDetail paymentDetail) {
        paymentDetailDatabaseService.update(paymentDetail);
        return paymentDetail;
    }


}
