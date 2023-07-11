package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.Client;
import com.example.insuranceapplication.entity.updateDto.ClientUpdateDto;
import com.example.insuranceapplication.repository.ClientRepository;
import com.example.insuranceapplication.service.database.ClientDatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
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

    @Override
    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Optional<Client> updateWithCheck(Integer id, ClientUpdateDto clientUpdateDto) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent() && clientUpdateDto != null) {
            Client client = clientOptional.get();
            if (clientUpdateDto.getSurname() != null) {
                client.setSurname(clientUpdateDto.getSurname());
            }
            if (clientUpdateDto.getName() != null) {
                client.setName(clientUpdateDto.getName());
            }
            if (clientUpdateDto.getDateOfBirthday() != null) {
                client.setDateOfBirthday(clientUpdateDto.getDateOfBirthday());
            }
            if (clientUpdateDto.getEMail() != null) {
                client.setEMail(clientUpdateDto.getEMail());
            }
            if (clientUpdateDto.getPhoneNumber() != null) {
                client.setPhoneNumber(clientUpdateDto.getPhoneNumber());
            }
            if (clientUpdateDto.getAddress() != null) {
                client.setAddress(clientUpdateDto.getAddress());
            }

            clientRepository.save(client);
            return Optional.of(client);
        }
        return Optional.empty();
    }
}
