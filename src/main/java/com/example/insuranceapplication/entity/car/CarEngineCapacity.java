package com.example.insuranceapplication.entity.car;

import com.example.insuranceapplication.entity.Coefficient;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "carEngineCapacity")
public class CarEngineCapacity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "engine_capacity")
    private Double engineCapacity;

    @Basic(optional = false)
    @Column(name = "coefficient")
    private Double coefficient;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column(name = "finished_at")
    private Timestamp finishedAt;

    @OneToMany(mappedBy = "carEngineCapacity")
    private List<Coefficient> coefficients;

}
