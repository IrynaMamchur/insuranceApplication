package com.example.insuranceapplication.entity.updateDto;

import com.example.insuranceapplication.entity.InsurancePayment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class ClientRequestUpdateDto {
    public String clientRequestStatus;
//    public Double carCost;
    public InsurancePayment insurancePayment;
}
