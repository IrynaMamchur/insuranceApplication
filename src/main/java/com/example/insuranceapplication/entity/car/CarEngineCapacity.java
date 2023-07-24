package com.example.insuranceapplication.entity.car;

import com.example.insuranceapplication.entity.Coefficient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "carEngineCapacity")
public class CarEngineCapacity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "engine_capacity")
    private Double engineCapacity;

    @Basic(optional = false)
    @Column(name = "coefficient")
    private Double coefficient;


    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "finished_at")
    private Timestamp finishedAt;

    @OneToMany(mappedBy = "carEngineCapacity")
    @JsonIgnore
    private List<Coefficient> coefficients;

}
