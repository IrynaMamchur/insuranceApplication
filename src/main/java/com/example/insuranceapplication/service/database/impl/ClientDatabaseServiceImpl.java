package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.Client;
import com.example.insuranceapplication.entity.enam.ContractInClientStatus;
import com.example.insuranceapplication.repository.ClientRepository;
import com.example.insuranceapplication.service.database.ClientDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientDatabaseServiceImpl implements ClientDatabaseService {
private final ClientRepository clientRepository;


    @Override
    public Client getClientByName(String name, String surname) {
        return clientRepository.getClientByNameAndSurname(name, surname);
    }

    @Override
    public Client getClientByDateOfBirthday(LocalDate dateOfBirthday) {
        return clientRepository.getClientByDateOfBirthday(dateOfBirthday);
    }

    @Override
    public List<Client> getAllClientByContractStatus(ContractInClientStatus contractInClientStatus) {
        return (List<Client>) clientRepository.getClientsByContractInClientStatus(contractInClientStatus);
    }

    @Override
    public Optional<Client> getClientById(Integer id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client create(Client client) {
        return clientRepository.save(new Client());
    }

    @Override
    public Client update(Client client) {
        return clientRepository.save(client);
    }
}
