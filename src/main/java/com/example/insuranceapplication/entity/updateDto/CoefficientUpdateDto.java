package com.example.insuranceapplication.entity.updateDto;

import com.example.insuranceapplication.entity.car.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CoefficientUpdateDto {
    public CarBrand carBrand;
    public CarEngineCapacity carEngineCapacity;
    public CarInsuranceProgram carInsuranceProgram;
    public CarYearOfIssue carYearOfIssue;
    public Double coefficientForCar;
    public CarQuantityOfPayments carQuantityOfPayments;

}
