package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.entity.Payment;
import com.example.insuranceapplication.entity.car.CarBrand;
import com.example.insuranceapplication.service.database.PaymentDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentDatabaseService paymentDatabaseService;

    @GetMapping(value = "/payment/find/contract_number_id/{contractNumberId}")
    public List<Payment> getPaymentsByContractNumberId(@PathVariable(name = "contractNumberId")Integer contractNumberId){
        List<Payment> payments = paymentDatabaseService.getPaymentsByContractNumberId(contractNumberId);
        return payments;
    }

    @GetMapping(value = "/payment/find/amount/{amount}")
    public List<Payment> getPaymentsByAmount(@PathVariable(name = "amount")Integer amount){
        List<Payment> payments = paymentDatabaseService.getPaymentsByAmount(amount);
        return payments;
    }


    @GetMapping(value = "/payment/find/all")
    public List<Payment> getAllPayments (){
        List<Payment> payments = paymentDatabaseService.getAllPayments();
        return payments;
    }

    @GetMapping(value = "/payment/find/id/{id}")
    public Optional<Payment> getPaymentById(@PathVariable(name = "id") Integer id){
        Optional<Payment> payment = paymentDatabaseService.getPaymentById(id);
        return payment;
    }

    @PostMapping(value = "/payment/create")
    public Payment createNewPayment(@RequestBody Payment payment) {
        paymentDatabaseService.create(payment);
        return payment;
    }

    @PutMapping(value = "/payment/update")
    public Payment updatePayment(@RequestBody Payment payment) {
        paymentDatabaseService.update(payment);
        return payment;
    }

}
