package com.example.insuranceapplication.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class InsurancePaymentDto {

    public Integer id;

    public Integer coefficientId;

    public Double carCost;

}
