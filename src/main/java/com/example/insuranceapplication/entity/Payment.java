package com.example.insuranceapplication.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentId")
    private Integer paymentId;

    @Basic(optional = false)
    @Column(name = "datePlan")
    private LocalDate datePlan;

    @Basic(optional = false)
    @Column(name = "dateOfPayment")
    private LocalDate dateOfPayment;

    @Basic(optional = false)
    @Column(name = "amount")
    private Double amount;

    @Basic(optional = false)
    @Column(name = "contractNumberID")
    private Integer contractNumberId;

    @Column(name = "created_at")
    private Timestamp createdAt;
}
