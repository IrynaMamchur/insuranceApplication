package com.example.insuranceapplication.entity.dto;

import com.example.insuranceapplication.entity.enam.CarQuantityOfPaymentsNumbers;

public class CoefficientDto {
     public Integer id;
     public String carBrandName;
     public Double engineCapacity;
     public String insuranceProgramName;
    public Integer carFirstRegistr;
    public CarQuantityOfPaymentsNumbers number;

    public CoefficientDto(Integer id, String carBrandName, Double engineCapacity, String insuranceProgramName, Integer carFirstRegistr, CarQuantityOfPaymentsNumbers number) {
        this.id = id;
        this.carBrandName = carBrandName;
        this.engineCapacity = engineCapacity;
        this.insuranceProgramName = insuranceProgramName;
        this.carFirstRegistr = carFirstRegistr;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarBrandName() {
        return carBrandName;
    }

    public void setCarBrandName(String carBrandName) {
        this.carBrandName = carBrandName;
    }

    public Double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getInsuranceProgramName() {
        return insuranceProgramName;
    }

    public void setInsuranceProgramName(String insuranceProgramName) {
        this.insuranceProgramName = insuranceProgramName;
    }

    public Integer getCarFirstRegistr() {
        return carFirstRegistr;
    }

    public void setCarFirstRegistr(Integer carFirstRegistr) {
        this.carFirstRegistr = carFirstRegistr;
    }

    public CarQuantityOfPaymentsNumbers getNumber() {
        return number;
    }

    public void setNumber(CarQuantityOfPaymentsNumbers number) {
        this.number = number;
    }
}
