package com.example.insuranceapplication.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "contractNumber")
public class ContractNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "clientID")
    private Integer clientID;

    @Basic(optional = false)
    @Column(name = "requestsId")
    private Integer requestsId;

    @Basic(optional = false)
    @Column(name = "payment1Id")
    private Integer payment1Id;

    @Basic(optional = false)
    @Column(name = "payment2Id")
    private Integer payment2Id;

    @Basic(optional = false)
    @Column(name = "payment3Id")
    private Integer payment3Id;

    @Basic(optional = false)
    @Column(name = "payment4Id")
    private Integer payment4Id;

    @Column(name = "isInsuranceEvent")
    private boolean isInsuranceEvent;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "finished_at")
    private Timestamp finishedAt;
}
