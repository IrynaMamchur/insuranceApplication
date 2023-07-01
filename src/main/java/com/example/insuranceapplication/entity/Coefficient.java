package com.example.insuranceapplication.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "coefficient")
public class Coefficient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "car_brand_id")
    private Double carBrandId;

    @Basic(optional = false)
    @Column(name = "car_engine_id")
    private Double carEngineId;

    @Basic(optional = false)
    @Column(name = "car_insurance_program_id")
    private Double carInsuranceProgramId;

    @Basic(optional = false)
    @Column(name = "car_year_of_issue_id")
    private Double carYearOfIssueId;

    @Column(name = "coefficient")
    private Double coefficientForCar;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Basic(optional = false)
    @Column(name = "car_number_of_payments_id")
    private Double carNumberOfPaymentsId;

}
