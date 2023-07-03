package com.example.insuranceapplication.entity;

import com.example.insuranceapplication.entity.car.*;
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

    @ManyToOne
    @JoinColumn(name = "car_brand_id")
    private CarBrand carBrand;

    @ManyToOne
    @JoinColumn(name = "car_engine_id")
    private CarEngineCapacity carEngineCapacity;

    @ManyToOne
    @JoinColumn(name = "car_insurance_program_id")
    private CarInsuranceProgram carInsuranceProgram;

    @ManyToOne
    @JoinColumn(name = "car_year_of_issue_id")
    private CarYearOfIssue carYearOfIssue;

    @Column(name = "coefficient")
    private Double coefficientForCar;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "carQuantityOfPaymentsId")
    private CarQuantityOfPayments carQuantityOfPayments;


    @OneToOne(mappedBy = "coefficient")
    private InsurancePayment insurancePayment;

}
