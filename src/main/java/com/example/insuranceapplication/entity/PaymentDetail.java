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
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @Column(name = "date_payment_plan")
    private LocalDate datePaymentPlan;

    @Column(name = "amount_plan")
    private Double amount1Plan;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column(name = "number")
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "contract_number_id")
    private ContractNumber contractNumber;

}
