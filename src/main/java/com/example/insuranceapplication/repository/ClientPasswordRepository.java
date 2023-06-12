package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.ClientPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientPasswordRepository extends JpaRepository<ClientPassword, Integer> {

    ClientPassword getClientPasswordByLoginAndPassword(String login, String password);

}
