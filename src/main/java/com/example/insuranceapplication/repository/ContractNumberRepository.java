package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.entity.enam.InsuranceEventInContractNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query(value = "SELECT " +
            "ContractNumber .insuranceEventInContractNumber\n" +
            "FROM ContractNumber \n" +
            "where ContractNumber .id = :id")
    InsuranceEventInContractNumber getInsuranceEvent (@Param("id") Integer id);



    @Query(value = "SELECT\n " +
            "ContractNumber.id,\n" +
            "InsurancePayment .insurancePayment,\n" +
            "ClientRequests .carCost\n" +
            "FROM ContractNumber \n" +
                    "JOIN InsurancePayment ON ClientRequests.insurancePaymentId= InsurancePayment .id \n" +
                    "JOIN ClientRequests ON ContractNumber .requestsId = ClientRequests .id\n" +
                    "where ContractNumber .startedAt = :startedAt ")
    Collection<ContractNumber> createFirstReport(@Param("startedAt") Timestamp startedAt);

}
