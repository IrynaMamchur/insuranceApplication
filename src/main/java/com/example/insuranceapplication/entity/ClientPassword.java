package com.example.insuranceapplication.entity;

import com.example.insuranceapplication.entity.enam.PasswordStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "clientPassword")
@AllArgsConstructor
@NoArgsConstructor
public class ClientPassword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "client_id")
    private Integer clientId;

    @Basic(optional = false)
    @Column(name = "login", length = 30)
    private String login;

    @Basic(optional = false)
    @Column(name = "password")
    private String password;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "status")
    private PasswordStatus passwordStatus;

}
