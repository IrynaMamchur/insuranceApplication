package com.example.insuranceapplication.controller.paymentController;

import com.example.insuranceapplication.entity.payment.PaymentDetail;
import com.example.insuranceapplication.entity.updateDto.PaymentDetailUpdateDto;
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

    @DeleteMapping(value = "/paymentDetail/delete/{id}")
    public ResponseEntity<Integer> delete(@PathVariable Integer id){
        paymentDetailDatabaseService.delete(id);
        return ResponseEntity.ok().build();
    }

        @PutMapping(value = "/paymentDetail/update/withCheck/{id}")
        public ResponseEntity< Optional<PaymentDetail>> updateWithCheck(@PathVariable(name = "id") Integer id, @RequestBody PaymentDetailUpdateDto paymentDetailUpdateDto) {
            Optional<PaymentDetail> paymentDetail =  paymentDetailDatabaseService.updateWithCheck(id, paymentDetailUpdateDto);
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

