package com.example.insuranceapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;


@Data
@Entity
@Table(name = "client")

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "client_password_id")
    private ClientPassword clientPassword;

    @Basic
    @Column(insertable = false, updatable = false, name = "client_password_id")
    private Integer clientPasswordId;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;


    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<ClientRequests> clientRequestsList;

}