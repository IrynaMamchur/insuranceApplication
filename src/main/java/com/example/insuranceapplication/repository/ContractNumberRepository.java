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

    Collection<ContractNumber> getContractNumberByFinishedAtAfter(Timestamp finishedAt);

    Collection<ContractNumber> getContractNumberByFinishedAt(Timestamp finishedAt);

    Collection<ContractNumber> getContractNumberByStartedAt(Timestamp startedAt);

    Collection<ContractNumber> getContractNumberByStartedAtAfter(Timestamp startedAt);

    @Query(value = "SELECT " +
            "ContractNumber .insuranceEventInContractNumber\n" +
            "FROM ContractNumber \n" +
            "where ContractNumber .id = :id", nativeQuery = true)
    InsuranceEventInContractNumber getInsuranceEvent(@Param("id") Integer id);

}
