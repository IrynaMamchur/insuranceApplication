package com.example.insuranceapplication.entity.car;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "carInsuranceProgram")
public class CarInsuranceProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "insuranceProgramName", length = 30)
    private String insuranceProgramName;

    @Basic(optional = false)
    @Column(name = "coefficient")
    private Double coefficient;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "finished_at")
    private Timestamp finishedAt;


}