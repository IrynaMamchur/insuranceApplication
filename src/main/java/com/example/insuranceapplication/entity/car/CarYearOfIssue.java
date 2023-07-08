package com.example.insuranceapplication.entity.car;

import com.example.insuranceapplication.entity.Coefficient;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "carYearOfIssue")
public class CarYearOfIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "car_first_registr")
    private Integer carFirstRegistr;

    @Basic(optional = false)
    @Column(name = "coefficient")
    private Double coefficient;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column(name = "finished_at")
    private Timestamp finishedAt;

    @OneToMany(mappedBy = "carYearOfIssue")
    private List<Coefficient> coefficients;
}
