package com.example.insuranceapplication.entity.payment;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.entity.payment.Payment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "paymentDetail")
public class PaymentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "payment_id")
    private Integer paymentId;

    @Column(name = "date_payment_plan")
    private LocalDate datePaymentPlan;

    @Column(name = "amount_plan")
    private Double amountPlan;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column(name = "number")
    private Integer number;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "contract_number_id")
    private ContractNumber contractNumber;

    @Basic
    @Column(insertable=false, updatable=false, name = "contract_number_id")
    private Integer contractNumberId;

}
