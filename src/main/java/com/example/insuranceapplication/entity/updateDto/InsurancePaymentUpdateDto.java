package com.example.insuranceapplication.entity.updateDto;

import com.example.insuranceapplication.entity.Coefficient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class InsurancePaymentUpdateDto {
    public Coefficient coefficient;
    public Double insurancePaymentAmount;

}
