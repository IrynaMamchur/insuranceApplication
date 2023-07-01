package com.example.insuranceapplication.entity.car;

import com.example.insuranceapplication.entity.enam.CarQuantityOfPaymentsNumbers;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "carQuantityOfPayments")
public class CarQuantityOfPayments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Enumerated(EnumType.ORDINAL)
    @Basic(optional = false)
    @Column(name = "number")
    private CarQuantityOfPaymentsNumbers number;

    @Basic(optional = false)
    @Column(name = "coefficient")
    private Double coefficient;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column(name = "finished_at")
    private Timestamp finishedAt;
}
