package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.repository.ContractNumberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.example.insuranceapplication.entity.enam.InsuranceEventInContractNumber.DECLARED;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ContractNumberDatabaseServiceImplTest {
@Mock
private ContractNumberRepository contractNumberRepository;
private ContractNumberDatabaseServiceImpl underTest;

@InjectMocks
ContractNumberDatabaseServiceImpl contractNumberDatabaseService;

@BeforeEach
void setup(){
underTest = new ContractNumberDatabaseServiceImpl(contractNumberRepository);
}

    @Test
    void getContractNumbersByIdAfter() {
    underTest.getContractNumbersByIdAfter(1);
    verify(contractNumberRepository).getContractNumbersByIdAfter(1);
    }

    @Test
    void getContractNumbersByIdAfter_nullReturned() {
        underTest.getContractNumbersByIdAfter(1).isEmpty();
        assertTrue((contractNumberRepository).getContractNumbersByIdAfter(1).isEmpty());
    }

    @Test
    void getContractNumberByInsuranceEventInContractNumber() {
    underTest.getContractNumberByInsuranceEventInContractNumber(DECLARED);
    verify(contractNumberRepository).getContractNumberByInsuranceEventInContractNumber(DECLARED);
    }

    @Test
    void getContractNumberByInsuranceEventInContractNumber_nullReturned() {
        underTest.getContractNumberByInsuranceEventInContractNumber(DECLARED).isEmpty();
        assertTrue((contractNumberRepository).getContractNumberByInsuranceEventInContractNumber(DECLARED).isEmpty());
    }


    @Test
    void getContractNumberById() {
    underTest.getContractNumberById(1);
    verify(contractNumberRepository).findById(1);
    }

    @Test
    void getContractNumberById_nullReturned() {
        underTest.getContractNumberById(null);
        verify(contractNumberRepository).findById(isNull());
    }

    @Test
    void create() {
    ContractNumber contractNumber = new ContractNumber();
    underTest.create(contractNumber);
        ArgumentCaptor<ContractNumber> contractNumberArgumentCaptor = ArgumentCaptor.forClass(ContractNumber.class);
        verify(contractNumberRepository).save(contractNumberArgumentCaptor.capture());
        ContractNumber captureContractNumber = contractNumberArgumentCaptor.getValue();
        assertEquals(captureContractNumber,contractNumber);
    }

    @Test
    void create_null() {
        ContractNumber contractNumber = new ContractNumber();
        boolean b = underTest.create(contractNumber)==null;
        ArgumentCaptor<ContractNumber> contractNumberArgumentCaptor = ArgumentCaptor.forClass(ContractNumber.class);
        verify(contractNumberRepository).save(contractNumberArgumentCaptor.capture());
        ContractNumber captureContractNumber = contractNumberArgumentCaptor.getValue();
        assertEquals(captureContractNumber,contractNumber);
    }

    @Test
    void getInsuranceEvent() {
    underTest.getInsuranceEvent(1);
    verify(contractNumberRepository).getInsuranceEvent(1);
    }

    @Test
    void getInsuranceEvent_nullReturned() {
        underTest.getInsuranceEvent(null);
        verify(contractNumberRepository).getInsuranceEvent(isNull());
    }


    @Test
    void getAllContractNumbers() {
    underTest.getAllContractNumbers();
    verify(contractNumberRepository).findAll();
    }

    @Test
    void getAllContractNumbers_emptyListReturn() {
    underTest.getAllContractNumbers().isEmpty();
    assertTrue((contractNumberRepository).findAll().isEmpty());
    }

    @Test
    void delete() {
    underTest.delete(1);
    verify(contractNumberRepository).deleteById(1);
    }

    @Test
    void delete_null() {
        underTest.delete(null);
        verify(contractNumberRepository).deleteById(isNull());
    }


    @Test
    void updateWithCheck() {
    }
}