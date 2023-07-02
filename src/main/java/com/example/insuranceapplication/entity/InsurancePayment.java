package com.example.insuranceapplication.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "insurance_payment")
public class InsurancePayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "coefficient_id")
    private Coefficient coefficient;

    @Column(name = "insurance_payment")
    private Double insurancePayment;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @OneToOne(mappedBy = "insurancePayment")
    private ClientRequests clientRequests;

}
