package com.example.insuranceapplication.entity.updateDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CarInsuranceProgramUpdateDto {
    public String insuranceProgramName;
    public Double coefficient;
}
