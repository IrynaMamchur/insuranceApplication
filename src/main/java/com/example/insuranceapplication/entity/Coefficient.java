package com.example.insuranceapplication.entity;

import com.example.insuranceapplication.entity.car.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "coefficient")
public class Coefficient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "car_brand_id")
    private CarBrand carBrand;

    @Basic
    @Column(insertable=false, updatable=false, name = "car_brand_id")
    private Integer carBrandId;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "car_engine_id")
    private CarEngineCapacity carEngineCapacity;

    @Basic
    @Column(insertable=false, updatable=false, name = "car_engine_id")
    private Integer carEngineCapacityId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "car_insurance_program_id")
    private CarInsuranceProgram carInsuranceProgram;

    @Basic
    @Column(insertable=false, updatable=false, name = "car_insurance_program_id")
    private Integer carInsuranceProgramId;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "car_year_of_issue_id")
    private CarYearOfIssue carYearOfIssue;

    @Basic
    @Column(insertable=false, updatable=false, name = "car_year_of_issue_id")
    private Integer carYearOfIssueId;

    @Column(name = "coefficient")
    private Double coefficientForCar;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "carQuantityOfPaymentsId")
    private CarQuantityOfPayments carQuantityOfPayments;

    @Basic
    @Column(insertable=false, updatable=false, name = "carQuantityOfPaymentsId")
    private Integer carQuantityOfPaymentsId;


    @OneToOne(mappedBy = "coefficient")
    @JsonIgnore
    private InsurancePayment insurancePayment;

}
