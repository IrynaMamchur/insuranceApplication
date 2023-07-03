package com.example.insuranceapplication.entity.car;

import com.example.insuranceapplication.entity.Coefficient;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "carInsuranceProgram")
public class CarInsuranceProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "insurance_program_name", length = 30)
    private String insuranceProgramName;

    @Basic(optional = false)
    @Column(name = "coefficient")
    private Double coefficient;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column(name = "finished_at")
    private Timestamp finishedAt;

    @Column(name = "optional", length = 60)
    private String optional;

    @OneToMany(mappedBy = "carInsuranceProgram")
    private List<Coefficient> coefficients;

}
