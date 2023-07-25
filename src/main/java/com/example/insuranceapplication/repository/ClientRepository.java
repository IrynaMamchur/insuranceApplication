package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    /**
     * Finds a Client entity from database by name and surname of the Client
     * @param name       The name of the Client
     * @param surname    The surname of the Client
     * @return  Client entity from database that was found by name and surname of the Client
     */
    Client getClientByNameAndSurname(String name, String surname);


    /**
     * Finds a Client entity from database by date of birthday of the Client
     * @param dateOfBirthday  The date of birthday of the Client
     * @return Client entity from database that was found by date of birthday of the Client
     */
    Client getClientByDateOfBirthday(LocalDate dateOfBirthday);

}
