package com.example.insuranceapplication.entity;

import com.example.insuranceapplication.entity.enam.InsuranceEventInContractNumber;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "contractNumber")
public class ContractNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "client_id")
    private Integer clientId;

    @Basic(optional = false)
    @Column(name = "requests_id")
    private Integer requestsId;

    @Basic(optional = false)
    @Column(name = "paymentDetail_id")
    private Integer paymentDetailId;

    @Column(name = "is_insurance_event")
    private InsuranceEventInContractNumber insuranceEventInContractNumber;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column(name = "started_at")
    private Timestamp startedAt;

    @Column(name = "finished_at")
    private Timestamp finishedAt;
}
