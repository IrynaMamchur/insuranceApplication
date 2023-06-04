package com.example.insuranceapplication.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "client")

public class Client {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "clientId")
        private Integer clientId;

        @Basic(optional = false)
        @Column(name = "surname")
        private String surname;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "date")
    private LocalDate date;

    @Basic(optional = false)
    @Column(name = "e-mail")
    private String e_mail;


    @Column(name = "isContract")
    private boolean isContract;
}
