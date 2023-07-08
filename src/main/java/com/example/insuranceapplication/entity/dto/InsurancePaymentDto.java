package com.example.insuranceapplication.entity.dto;


public class InsurancePaymentDto {

    public Integer id;
    public Integer coefficientId;
    public Integer carCostId;

    public InsurancePaymentDto(Integer id, Integer coefficientId, Integer carCostId) {
        this.id = id;
        this.coefficientId = coefficientId;
        this.carCostId = carCostId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCoefficientId() {
        return coefficientId;
    }

    public void setCoefficientId(Integer coefficientId) {
        this.coefficientId = coefficientId;
    }

    public Integer getCarCostId() {
        return carCostId;
    }

    public void setCarCostId(Integer carCostId) {
        this.carCostId = carCostId;
    }
}
