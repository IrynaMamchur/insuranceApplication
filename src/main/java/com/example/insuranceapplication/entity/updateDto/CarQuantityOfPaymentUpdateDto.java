package com.example.insuranceapplication.entity.updateDto;

import com.example.insuranceapplication.entity.enam.CarQuantityOfPaymentsNumbers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CarQuantityOfPaymentUpdateDto {
    public CarQuantityOfPaymentsNumbers number;
    public Double coefficient;
}
