package com.example.insuranceapplication.entity;

import com.example.insuranceapplication.entity.enam.ClientRequestStatus;
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

    @Basic(optional = false)
    @Column(name = "client_id")
    private Integer clientId;

    @Basic(optional = false)
    @Column(name = "brand_id")
    private Integer brandId;

    @Basic(optional = false)
    @Column(name = "engine_capacity_id")
    private Integer engineCapacityId;

    @Basic(optional = false)
    @Column(name = "car_first_registr_id")
    private Integer careFirstRegistrId;

    @Basic(optional = false)
    @Column(name = "insurance_program_id")
    private Integer insuranceProgramId;

    @Column(name = "status")
    private ClientRequestStatus clientRequestStatus;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Basic(optional = false)
    @Column(name = "car_cost")
    private Double carCost;

    @Basic(optional = false)
    @Column(name = "coefficientId")
    private Integer coefficientId;

    @Basic(optional = false)
    @Column(name = "insurance_payment_id")
    private Integer insurancePaymentId;

    @Column(name = "car_number_of_payments_id")
    private Integer carNumberOfPaymentsId;

}
