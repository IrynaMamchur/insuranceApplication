package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.Client;
import com.example.insuranceapplication.entity.car.CarEngineCapacity;
import com.example.insuranceapplication.entity.enam.ContractInClientStatus;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ClientDatabaseService {

    Client getClientByName(String name, String surname);

    Client getClientByDateOfBirthday(LocalDate dateOfBirthday);

    List<Client> getAllClientByContractStatus(ContractInClientStatus contractInClientStatus);

    Optional<Client> getClientById(Integer id);

    List<Client> getAllClients();

    Client create(Client client);

    Client update(Client client);
}
