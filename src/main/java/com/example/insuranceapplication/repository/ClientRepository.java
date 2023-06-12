package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client getClientByNameAndSurname (String name, String surname);

    Client getClientByDateOfBirthday (LocalDate dateOfBirthday);

}
