package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.entity.enam.InsuranceEventInContractNumber;
import com.example.insuranceapplication.repository.ContractNumberRepository;

import java.util.List;
import java.util.Optional;

public interface ContractNumberDatabaseService {

    List<ContractNumber> getContractNumbersByIdAfter(Integer id);

    List<ContractNumber> getContractNumberByInsuranceEventInContractNumber(InsuranceEventInContractNumber insuranceEventInContractNumber);

//    List<ContractNumber> getContractNumberByFinishedAtAfter(Timestamp finishedAt);
//
//    List<ContractNumber> getContractNumberByFinishedAt(Timestamp finishedAt);
//
//    List<ContractNumber> getContractNumberByStartedAtAfter(Timestamp startedAt);
//
//    List<ContractNumber> getContractNumberByStartedAt(Timestamp startedAt);

    List<ContractNumber> getContractNumberByAmountAll(Double amountAll);

    List<ContractNumber> getContractNumberByClientId(Integer clientId);

    List<ContractNumber>  getAllContractNumbers();

    Optional<ContractNumber> getContractNumberById(Integer id);

    ContractNumber create(ContractNumber contractNumber);

    ContractNumber update(ContractNumber contractNumber);
   }
