package com.example.insuranceapplication.entity.updateDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class PaymentUpdateDto {
    public LocalDate dateOfPayment;
    public Double amount;

}
