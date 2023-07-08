package com.example.insuranceapplication.entity.updateDto;

import com.example.insuranceapplication.entity.InsurancePayment;
import com.example.insuranceapplication.entity.enam.ClientRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class ClientRequestUpdateDto {
    public ClientRequestStatus clientRequestStatus;
    public Double carCost;
    public InsurancePayment insurancePayment;
}
