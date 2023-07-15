package com.example.insuranceapplication.entity.dto;

import com.example.insuranceapplication.entity.enam.CarQuantityOfPaymentsNumbers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter

public class CoefficientDto {
    public Integer id;

    public String carBrandName;

    public Double engineCapacity;

    public String insuranceProgramName;

    public Integer carFirstRegistr;

    public String number;

}
