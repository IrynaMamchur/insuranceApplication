package com.example.insuranceapplication.entity;

import jakarta.persistence.*;
import lombok.Data;

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
    @Column(name = "date")
    private LocalDate date;

    @Basic(optional = false)
    @Column(name = "amount")
    private Double amount;

    @Basic(optional = false)
    @Column(name = "contractNumberID")
    private Integer contractNumberId;

}
