package com.example.insuranceapplication.entity.car;

import com.example.insuranceapplication.entity.Coefficient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "carBrand")
public class CarBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "carBrandName", length = 30)
    private String carBrandName;

    @Basic(optional = false)
    @Column(name = "coefficient")
    private Double coefficient;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column(name = "finished_at")
    private Timestamp finishedAt;

    @OneToMany(mappedBy = "carBrand")
    @JsonIgnore
    private List<Coefficient> coefficients;

}
