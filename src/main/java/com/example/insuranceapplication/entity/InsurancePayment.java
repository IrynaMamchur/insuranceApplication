package com.example.insuranceapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "insurancePayment")
public class InsurancePayment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "coefficient_id")
    private Coefficient coefficient;

    @Basic
    @Column(insertable=false, updatable=false, name = "coefficient_id")
    private Integer coefficientId;


    @Column(name = "insurance_payment")
    private Double insurancePaymentAmount;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column(name = "car_cost")
    private Double carCost;

    @OneToOne(mappedBy = "insurancePayment")
    @JsonIgnore
    private ClientRequests clientRequests;

}
