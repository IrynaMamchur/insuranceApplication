package com.example.insuranceapplication.entity.car;

import com.example.insuranceapplication.entity.enam.CarNumberOfPaymentsNumbers;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "carNumberOfPayments")
public class CarNumberOfPayments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "number")
    private CarNumberOfPaymentsNumbers number;

    @Basic(optional = false)
    @Column(name = "coefficient")
    private Double coefficient;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column(name = "finished_at")
    private Timestamp finishedAt;
}
