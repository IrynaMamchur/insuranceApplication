package com.example.insuranceapplication.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "clientRequests")

public class ClientRequests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "clientId")
    private Integer clientId;

    @Basic(optional = false)
    @Column(name = "brandId")
    private String brandID;

    @Basic(optional = false)
    @Column(name = "engineCapacityId")
    private Integer engineCapacityId;

    @Basic(optional = false)
    @Column(name = "carFirstRegistrId")
    private Integer careFirstRegistrId;

    @Basic(optional = false)
    @Column(name = "insuranceProgramId")
    private Integer insuranceProgramId;

    @Column(name = "isConfirmed")
    private boolean isConfirmed;

    @Column(name = "created_at")
    private Timestamp createdAt;
}
