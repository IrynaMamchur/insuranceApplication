package com.example.insuranceapplication.entity.updateDto;

import com.example.insuranceapplication.entity.car.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CoefficientUpdateDto {
    public Integer carBrandId;
    public Integer carEngineCapacityId;
    public Integer carInsuranceProgramId;
    public Integer carYearOfIssueId;
    public Double coefficientForCar;
    public Integer carQuantityOfPaymentsId;

}
