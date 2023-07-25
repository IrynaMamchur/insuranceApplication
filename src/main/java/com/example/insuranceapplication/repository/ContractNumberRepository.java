package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.entity.enam.InsuranceEventInContractNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ContractNumberRepository extends JpaRepository<ContractNumber, Integer> {

    /**
     * Finds an ContractNumber entity from database by the specified id of the ContractNumber after set value id
     * @param id  The id of the ContractNumber
     * @return   ContractNumber entity from database by the specified id of the ContractNumber after set value id
     */
    Collection<ContractNumber> getContractNumbersByIdAfter(Integer id);

    /**
     * Finds an ContractNumber entity from database by status of insurance event of the ContractNumber
     * @param insuranceEventInContractNumber  The status of insurance event of the ContractNumber
     * @return  ContractNumber entity from database by status of insurance event of the ContractNumber
     */
    Collection<ContractNumber> getContractNumberByInsuranceEventInContractNumber(InsuranceEventInContractNumber insuranceEventInContractNumber);

    /**
     * Finds an insurance event from database by the specified id of the ContractNumber
     * @param id   The id of the ContractNumber
     * @return Status insurance event from database by the specified id of the ContractNumber
     */
    @Query(value = "SELECT " +
            "insuranceEventInContractNumber " +
            "FROM ContractNumber cn" +
            " where id = :id", nativeQuery = true)
    InsuranceEventInContractNumber getInsuranceEvent(@Param("id") Integer id);

}
