package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.Client;
import com.example.insuranceapplication.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ClientDatabaseServiceImplTest {

    @Mock
    private ClientRepository clientRepository;
    private ClientDatabaseServiceImpl underTest;

    @InjectMocks
    ClientDatabaseServiceImpl clientDatabaseService;

    @BeforeEach
    void setup() {
        underTest = new ClientDatabaseServiceImpl(clientRepository);
    }

    @Test
    void getClientByName() {
        underTest.getClientByName("Alex", "Alexer");
        verify(clientRepository).getClientByNameAndSurname("Alex", "Alexer");
    }

    @Test
    void getClientByName_nullReturned() {
        underTest.getClientByName(null, null);
        verify(clientRepository).getClientByNameAndSurname(isNull(), isNull());
    }


    @Test
    void getClientByDateOfBirthday() {
        underTest.getClientByDateOfBirthday(LocalDate.ofEpochDay(2006 - 05 - 15));
        verify(clientRepository).getClientByDateOfBirthday(LocalDate.ofEpochDay(2006 - 05 - 15));
    }

    @Test
    void getClientByDateOfBirthday_nullReturned() {
        underTest.getClientByDateOfBirthday(null);
        verify(clientRepository).getClientByDateOfBirthday(isNull());
    }

    @Test
    void getClientById() {
        underTest.getClientById(2);
        verify(clientRepository).findById(2);
    }

    @Test
    void getClientById_nullReturned() {
        underTest.getClientById(null);
        verify(clientRepository).findById(isNull());
    }

    @Test
    void getAllClients() {
        underTest.getAllClients();
        verify(clientRepository).findAll();
    }

    @Test
    void getAllClients_emptyListReturn() {
        underTest.getAllClients().isEmpty();
        assertTrue((clientRepository).findAll().isEmpty());
    }

    @Test
    void create() {
        Client client = new Client();
        underTest.create(client);
        ArgumentCaptor<Client> clientArgumentCaptor = ArgumentCaptor.forClass(Client.class);
        verify(clientRepository).save(clientArgumentCaptor.capture());
        Client captureClient = clientArgumentCaptor.getValue();
        assertEquals(captureClient, client);
    }

    @Test
    void create_null() {
        Client client = new Client();
        boolean b = underTest.create(client) == null;
        ArgumentCaptor<Client> clientArgumentCaptor = ArgumentCaptor.forClass(Client.class);
        verify(clientRepository).save(clientArgumentCaptor.capture());
        Client captureClient = clientArgumentCaptor.getValue();
        assertEquals(captureClient, client);
    }


    @Test
    void delete() {
        underTest.delete(1);
        verify(clientRepository).deleteById(1);
    }

    @Test
    void delete_null() {
        underTest.delete(null);
        verify(clientRepository).deleteById(isNull());
    }


    @Test
    void updateWithCheck() {
    }

}