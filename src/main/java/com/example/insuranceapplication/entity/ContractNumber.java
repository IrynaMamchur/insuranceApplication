package com.example.insuranceapplication.entity;

import com.example.insuranceapplication.entity.enam.InsuranceEventInContractNumber;
import com.example.insuranceapplication.entity.payment.PaymentDetail;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "contractNumber")

public class ContractNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "requests_id")
    private ClientRequests clientRequests;

    @Basic
    @Column(insertable = false, updatable = false, name = "requests_id")
    private Integer clientRequestsId;


    @Enumerated(EnumType.ORDINAL)
    @Column(name = "is_insurance_event")
    private InsuranceEventInContractNumber insuranceEventInContractNumber;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column(name = "started_at")
    private Timestamp startedAt;

    @Column(name = "finished_at")
    private Timestamp finishedAt;

    @OneToMany(mappedBy = "contractNumber")
    @JsonIgnore
    private List<PaymentDetail> paymentDetails;

}
