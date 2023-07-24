package com.example.insuranceapplication.entity.updateDto;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.entity.payment.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class PaymentDetailUpdateDto {
    public Integer paymentId;
    public LocalDate datePaymentPlan;
    public Double amountPlan;
    public Timestamp createdAt;
    public Integer number;
    public Integer contractNumberId;
}
