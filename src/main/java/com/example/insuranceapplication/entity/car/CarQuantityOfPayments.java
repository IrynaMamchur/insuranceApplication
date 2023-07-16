package com.example.insuranceapplication.entity.car;

import com.example.insuranceapplication.entity.Coefficient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "carQuantityOfPayments")
public class CarQuantityOfPayments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @Basic(optional = false)
    @Column(name = "number")
    private Integer number;

    @Basic(optional = false)
    @Column(name = "coefficient")
    private Double coefficient;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column(name = "finished_at")
    private Timestamp finishedAt;

    @OneToMany(mappedBy = "carQuantityOfPayments")
    @JsonIgnore
    private List<Coefficient> coefficients;
}
