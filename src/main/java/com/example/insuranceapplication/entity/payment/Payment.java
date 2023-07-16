package com.example.insuranceapplication.entity.payment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

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

    @OneToOne(mappedBy = "payment")
    @JsonIgnore
    private PaymentDetail paymentDetail;

}
