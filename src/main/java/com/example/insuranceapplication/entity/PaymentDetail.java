package com.example.insuranceapplication.entity;

import com.example.insuranceapplication.entity.enam.CarNumberOfPaymentsNumbers;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "paymentDetail")
public class PaymentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "insurance_payment_id")
    private Integer insurancePaymentId;

    @Column(name = "payment_1_id")
    private Integer payment1Id;

    @Column(name = "date_payment_1plan")
    private LocalDate datePayment1Plan;

    @Column(name = "amount_1plan")
    private Double amount1Plan;

    @Column(name = "payment_2_id")
    private Integer payment2Id;

    @Column(name = "date_payment_2plan")
    private LocalDate datePayment2Plan;

    @Column(name = "amount_2plan")
    private Double amount2Plan;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

}
