package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.entity.enam.InsuranceEventInContractNumber;
import com.example.insuranceapplication.entity.updateDto.ContractNumberUpdateDto;


import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface ContractNumberDatabaseService {
    /**
     * Finds an ContractNumber entity from database by the specified id of the ContractNumber after set value id
     * @param id  The id of the ContractNumber
     * @return   ContractNumber entity from database by the specified id of the ContractNumber after set value id
     */
    List<ContractNumber> getContractNumbersByIdAfter(Integer id);

    /**
     * Finds an ContractNumber entity from database by status of insurance event of the ContractNumber
     * @param insuranceEventInContractNumber  The status of insurance event of the ContractNumber
     * @return  ContractNumber entity from database by status of insurance event of the ContractNumber
     */
    List<ContractNumber> getContractNumberByInsuranceEventInContractNumber(InsuranceEventInContractNumber insuranceEventInContractNumber);

    /**
     * Finds all СontractNumber entity from database
     * @return    All СontractNumber entity from database
     */
    List<ContractNumber> getAllContractNumbers();

    /**
     * Finds an ContractNumber entity from database by the specified id of the ContractNumber
     * @param id   The id of the ContractNumber
     * @return  ContractNumber entity from database by the specified id of the ContractNumber
     */
    Optional<ContractNumber> getContractNumberById(Integer id);

    /**
     * Create new ContractNumber entity
     * @param contractNumber  New ContractNumber entity(Integer id, Integer clientRequestsId, InsuranceEventInContractNumber insuranceEventInContractNumber, Timestamp createdAt, Timestamp startedAt, Timestamp finishedAt)
     * @return  The new ContractNumber entity
     */
    ContractNumber create(ContractNumber contractNumber);

    /**
     * Finds an insurance event from database by the specified id of the ContractNumber
     * @param id   The id of the ContractNumber
     * @return Status insurance event from database by the specified id of the ContractNumber
     */
    InsuranceEventInContractNumber getInsuranceEvent(Integer id);

    /**
     * Deletion an ContractNumber entity from database by specified ContractNumber id
     * @param id  The id of the ContractNumber
     */
    void delete(Integer id);

    /**
     * Change one or more parameters in ContractNumber entity from database by specified ContractNumber id
     * @param id  The id of the ContractNumber
     * @param contractNumberUpdateDto   The parameters, which need to be replaced (String insuranceEventInContractNumber, Timestamp startedAt, Timestamp finishedAt)
     * @return The ContractNumber entity with new parameters
     */
    Optional<ContractNumber> updateWithCheck(Integer id, ContractNumberUpdateDto contractNumberUpdateDto);

}
