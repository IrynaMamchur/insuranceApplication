package com.example.insuranceapplication.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
@Data
@Entity
@Table(name = "clientRequests")

public class ClientRequests {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "requestsId")
        private Integer requestsId;

        @Basic(optional = false)
        @Column(name = "clientId")
        private Integer clientId;


    @Basic(optional = false)
    @Column(name = "carBrand")
    private String carBrand;

    @Basic(optional = false)
    @Column(name = "carModel")
    private String carModel;

    @Basic(optional = false)
    @Column(name = "engineCapacity")
    private Integer engineCapacity;

        @Basic(optional = false)
        @Column(name = "carFirstRegistr")
        private LocalDate careFirstRegistr;

    @Basic(optional = false)
    @Column(name = "insuranceProgram")
    private String insuranceProgram;


    @Column(name = "isConfirmed")
    private boolean isConfirmed;
}
