package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.Client;
import com.example.insuranceapplication.entity.updateDto.ClientUpdateDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ClientDatabaseService {

    Client getClientByName(String name, String surname);

    Client getClientByDateOfBirthday(LocalDate dateOfBirthday);

    Optional<Client> getClientById(Integer id);

    List<Client> getAllClients();

    Client create(Client client);

    void delete(Integer id);

    Optional<Client> updateWithCheck(Integer id, ClientUpdateDto clientUpdateDto);
}
