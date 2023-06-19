package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.entity.enam.InsuranceEventInContractNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Collection;

@Repository
public interface ContractNumberRepository extends JpaRepository<ContractNumber, Integer> {

    Collection<ContractNumber> getContractNumbersByIdAfter(Integer id);

    Collection<ContractNumber> getContractNumberByInsuranceEventInContractNumber(InsuranceEventInContractNumber insuranceEventInContractNumber);

    ContractNumberRepository getContractNumberByClientId(Integer clientId);

    Collection<ContractNumber> getContractNumberByFinishedAtAfter(Timestamp finishedAt);

    Collection<ContractNumber> getContractNumberByFinishedAt(Timestamp finishedAt);

    Collection<ContractNumber> getContractNumberByStartedAt(Timestamp startedAt);

    Collection<ContractNumber> getContractNumberByStartedAtAfter(Timestamp startedAt);

    Collection<ContractNumber> getContractNumberByAmountAll(Double amountAll);


}
