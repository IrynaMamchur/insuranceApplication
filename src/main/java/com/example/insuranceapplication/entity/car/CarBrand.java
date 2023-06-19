package com.example.insuranceapplication.entity.car;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "carBrand")
public class CarBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "car_brand_name", length = 30)
    private String carBrandName;

    @Basic(optional = false)
    @Column(name = "car_model_name", length = 30)
    private String carModelName;

    @Basic(optional = false)
    @Column(name = "coefficient")
    private Double coefficient;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column(name = "finished_at")
    private Timestamp finishedAt;
}
