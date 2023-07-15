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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "client_id")
    private Client client;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private ClientRequestStatus clientRequestStatus;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Basic(optional = false)
    @Column(name = "car_cost")
    private Double carCost;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "insurance_payment_id")
    private InsurancePayment insurancePayment;


    @OneToOne(mappedBy = "clientRequests")
    @JsonIgnore
    private ContractNumber contractNumber;

}
