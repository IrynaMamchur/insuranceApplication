package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.ClientPassword;
import com.example.insuranceapplication.entity.enam.PasswordStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ClientPasswordRepository extends JpaRepository<ClientPassword, Integer> {

    ClientPassword getClientPasswordByLoginAndPassword(String login, String password);

    Collection<ClientPassword>getClientPasswordsByPasswordStatus (PasswordStatus passwordStatus);
}
