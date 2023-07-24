package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.ClientRequests;
import com.example.insuranceapplication.repository.ClientRequestsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.insuranceapplication.entity.enam.ClientRequestStatus.IS_CONFIRMED;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ClientReguestsDatabaseServiceImplTest {

    @Mock
    private ClientRequestsRepository clientRequestsRepository;
    private ClientReguestsDatabaseServiceImpl underTest;

    @InjectMocks
    ClientReguestsDatabaseServiceImpl clientReguestsDatabaseService;

    @BeforeEach
    void setup() {
        underTest = new ClientReguestsDatabaseServiceImpl(clientRequestsRepository);
    }

    @Test
    void getClientRequestsByClientRequestStatus() {
        underTest.getClientRequestsByClientRequestStatus(IS_CONFIRMED);
        verify(clientRequestsRepository).getClientRequestsByClientRequestStatus(IS_CONFIRMED);
    }

    @Test
    void getClientRequestsByClientRequestStatus_nullReturned() {
        underTest.getClientRequestsByClientRequestStatus(null);
        verify(clientRequestsRepository).getClientRequestsByClientRequestStatus(isNull());
    }
    @Test
    void getClientRequestsByClientId() {
        underTest.getClientRequestsByClientId(1);
        verify(clientRequestsRepository).getClientRequestsByClientId(1);
    }

    @Test
    void getClientRequestsByClientId_nullReturned() {
        underTest.getClientRequestsByClientId(null);
        verify(clientRequestsRepository).getClientRequestsByClientId(isNull());
    }
    @Test
    void getClientRequestById() {
        underTest.getClientRequestById(1);
        verify(clientRequestsRepository).findById(1);
    }

    @Test
    void getClientRequestById_nullReturned() {
        underTest.getClientRequestById(null);
        verify(clientRequestsRepository).findById(isNull());
    }

    @Test
    void getAllClientRequests() {
        underTest.getAllClientRequests();
        verify(clientRequestsRepository).findAll();
    }

    @Test
    void getAllClientRequests_emptyListReturn() {
        underTest.getAllClientRequests().isEmpty();
        assertTrue((clientRequestsRepository).findAll().isEmpty());
    }

    @Test
    void create() {
        ClientRequests clientRequests = new ClientRequests();
        underTest.create(clientRequests);
        ArgumentCaptor<ClientRequests> clientRequestsArgumentCaptor = ArgumentCaptor.forClass(ClientRequests.class);
        verify(clientRequestsRepository).save(clientRequestsArgumentCaptor.capture());
        ClientRequests captureClientRequests = clientRequestsArgumentCaptor.getValue();
        assertEquals(captureClientRequests, clientRequests);
    }

    @Test
    void create_null() {
        ClientRequests clientRequests = new ClientRequests();
        boolean b =  underTest.create(clientRequests)==null;
        ArgumentCaptor<ClientRequests> clientRequestsArgumentCaptor = ArgumentCaptor.forClass(ClientRequests.class);
        verify(clientRequestsRepository).save(clientRequestsArgumentCaptor.capture());
        ClientRequests captureClientRequests = clientRequestsArgumentCaptor.getValue();
        assertEquals(captureClientRequests, clientRequests);
    }

    @Test
    void delete() {
        underTest.delete(1);
        verify(clientRequestsRepository).deleteById(1);
    }

    @Test
    void delete_null() {
        underTest.delete(null);
        verify(clientRequestsRepository).deleteById(isNull());
    }

    @Test
    void updateWithCheck() {
    }
}