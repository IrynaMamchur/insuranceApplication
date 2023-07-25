package com.example.insuranceapplication.entity;

import com.example.insuranceapplication.entity.enam.ClientRequestStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "clientRequests")

public class ClientRequests {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "client_id")
    private Client client;

    @Basic
    @Column(insertable = false, updatable = false, name = "client_id")
    private Integer clientId;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private ClientRequestStatus clientRequestStatus;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "insurance_payment_id")
    private InsurancePayment insurancePayment;

    @Basic
    @Column(insertable = false, updatable = false, name = "insurance_payment_id")
    private Integer insurancePaymentId;

    @OneToOne(mappedBy = "clientRequests")
    @JsonIgnore
    private ContractNumber contractNumber;


}
