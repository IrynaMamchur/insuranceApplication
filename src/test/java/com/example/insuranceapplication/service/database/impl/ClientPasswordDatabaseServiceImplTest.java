package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.enam.PasswordStatus;
import com.example.insuranceapplication.repository.ClientPasswordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class ClientPasswordDatabaseServiceImplTest {

    @Mock
    private ClientPasswordRepository clientPasswordRepository;
    private ClientPasswordDatabaseServiceImpl underTest;

    @InjectMocks
    ClientPasswordDatabaseServiceImpl clientPasswordDatabaseService;

    @BeforeEach
        void setup() {
            underTest = new ClientPasswordDatabaseServiceImpl(clientPasswordRepository);
        }
    @Test
    void getClientPassword() {
        underTest.getClientPassword("DFGHJsub", "DGhjddjnu");
        verify(clientPasswordRepository).getClientPasswordByLoginAndPassword("DFGHJsub", "DGhjddjnu");

    }

    @Test
    void getClientPassword_nullReturned() {
        underTest.getClientPassword(null, null);
        verify(clientPasswordRepository).getClientPasswordByLoginAndPassword(isNull(), isNull());
    }

    @Test
    void getAllClientPasswordsByPasswordStatus() {
        underTest.getAllClientPasswordsByPasswordStatus(PasswordStatus.valueOf("ACTIVE"));
        verify(clientPasswordRepository).getClientPasswordsByPasswordStatus(PasswordStatus.valueOf("ACTIVE"));
    }

    @Test
    void getAllClientPasswordsByPasswordStatus_nullReturned() {
        underTest.getAllClientPasswordsByPasswordStatus(null);
        verify(clientPasswordRepository).getClientPasswordsByPasswordStatus(isNull());
    }

    @Test
    void getClientPasswordById() {
        underTest.getClientPasswordById(1);
        verify(clientPasswordRepository).findById(1);
    }

    @Test
    void getClientPasswordById_nullReturned() {
        underTest.getClientPasswordById(null);
        verify(clientPasswordRepository).findById(isNull());
    }

    @Test
    void getAllClientPassword() {
        underTest.getAllClientPassword();
        verify(clientPasswordRepository).findAll();
    }

    @Test
    void getAllClientPassword_emptyListReturn() {
        underTest.getAllClientPassword().isEmpty();
        assertTrue((clientPasswordRepository).findAll().isEmpty());
    }

    @Test
    void verificationPassword() {
    }

    @Test
    void getClientPasswordByPassword() {
        underTest.getClientPasswordByPassword("Drtyjjsdbk");
        verify(clientPasswordRepository).getClientPasswordByPassword("Drtyjjsdbk");
    }

    @Test
    void getClientPasswordByPassword_nullReturned() {
        underTest.getClientPasswordByPassword(null);
        verify(clientPasswordRepository).getClientPasswordByPassword(isNull());
    }


    @Test
    void verificationLogin() {
    }

    @Test
    void getClientPasswordByLogin() {
        underTest.getClientPasswordByLogin("Drtgfdkkf");
        verify(clientPasswordRepository).getClientPasswordByLogin("Drtgfdkkf");
    }

    @Test
    void getClientPasswordByLogin_nullReturned() {
        underTest.getClientPasswordByLogin(null);
        verify(clientPasswordRepository).getClientPasswordByLogin(isNull());
    }

    @Test
    void delete() {
        underTest.delete(1);
        verify(clientPasswordRepository).deleteById(1);
    }

    @Test
    void delete_null() {
        underTest.delete(null);
        verify(clientPasswordRepository).deleteById(isNull());
    }

    @Test
    void updateWithCheck() {
    }


}