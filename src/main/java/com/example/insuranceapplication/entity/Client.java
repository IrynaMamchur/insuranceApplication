package com.example.insuranceapplication.entity;

import com.example.insuranceapplication.entity.enam.ContractInClientStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "client")

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "surname", length = 60)
    private String surname;

    @Basic(optional = false)
    @Column(name = "name", length = 60)
    private String name;

    @Basic(optional = false)
    @Column(name = "date_of_birthday")
    private LocalDate dateOfBirthday;

    @Basic(optional = false)
    @Column(name = "e_mail", length = 60)
    private String eMail;

    @Basic(optional = false)
    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Basic(optional = false)
    @Column(name = "address", length = 120)
    private String address;

    @Column(name = "is_contract")
    private ContractInClientStatus contractInClientStatus;

    @Column(name = "created_at")
    private Timestamp createdAt;

}