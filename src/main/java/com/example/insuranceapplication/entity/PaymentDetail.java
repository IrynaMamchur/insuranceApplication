package com.example.insuranceapplication.entity;

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

    @OneToOne
    @JoinColumn(name = "payment_1_id")
    private Payment payment1;

    @Column(name = "date_payment_1plan")
    private LocalDate datePayment1Plan;

    @Column(name = "amount_1plan")
    private Double amount1Plan;

    @OneToOne
    @JoinColumn(name = "payment_2_id")
    private Payment payment2;

    @Column(name = "date_payment_2plan")
    private LocalDate datePayment2Plan;

    @Column(name = "amount_2plan")
    private Double amount2Plan;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @OneToOne(mappedBy = "paymentDetail")
    private ContractNumber contractNumber;

}
