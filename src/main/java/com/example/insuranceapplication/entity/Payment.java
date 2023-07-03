package com.example.insuranceapplication.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.parameters.P;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "date_of_payment")
    private LocalDate dateOfPayment;

    @Basic(optional = false)
    @Column(name = "amount")
    private Double amount;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @OneToOne(mappedBy = "payment1")
    private PaymentDetail paymentDetail;

}
