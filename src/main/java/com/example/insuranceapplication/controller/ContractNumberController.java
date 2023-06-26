package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.entity.enam.InsuranceEventInContractNumber;
import com.example.insuranceapplication.service.database.ContractNumberDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ContractNumberController {

    private final ContractNumberDatabaseService contractNumberDatabaseService;


    @GetMapping(value = "/contract/find/amount_all")
    public List<ContractNumber> getAllContractNumbers() {
        List<ContractNumber> contractNumbers = contractNumberDatabaseService.getAllContractNumbers();
        return contractNumbers;
    }

    @GetMapping(value = "/contract/find/id/after/{id}")
    public List<ContractNumber> getContractNumbersByIdAfter(@PathVariable(name = "id") Integer id) {
        List<ContractNumber> contractNumbers = contractNumberDatabaseService.getContractNumbersByIdAfter(id);
        return contractNumbers;
    }

    @GetMapping(value = "/contract/find/finished/after/{finishedAt}")
    public List<ContractNumber> getContractNumberByFinishedAtAfter(@PathVariable(name = "finishedAt") Timestamp finishedAt) {
        List<ContractNumber> contractNumbers = contractNumberDatabaseService.getContractNumberByFinishedAtAfter(finishedAt);
        return contractNumbers;
    }
    @GetMapping(value = "/contract/find/finished/{finishedAt}")
    public List<ContractNumber> getContractNumberByFinishedAt(@PathVariable(name = "finishedAt") Timestamp finishedAt) {
        List<ContractNumber> contractNumbers = contractNumberDatabaseService.getContractNumberByFinishedAt(finishedAt);
        return contractNumbers;
    }

    @GetMapping(value = "/contract/find/started/after/{startedAt}")
    public List<ContractNumber> getContractNumberByStartedAtAfter(@PathVariable(name = "startedAt") Timestamp startedAt) {
        List<ContractNumber> contractNumbers = contractNumberDatabaseService.getContractNumberByStartedAtAfter(startedAt);
        return contractNumbers;
    }

    @GetMapping(value = "/contract/find/started/{startedAt}")
    public List<ContractNumber> getContractNumberByStartedAt(@PathVariable(name = "startedAt") Timestamp startedAt) {
        List<ContractNumber> contractNumbers = contractNumberDatabaseService.getContractNumberByStartedAt(startedAt);
        return contractNumbers;
    }


    @GetMapping(value = "/contract/find/insuranse_event/{insuranceEventInContractNumber}")
    public List<ContractNumber> getContractNumberByInsuranceEvent(@PathVariable(name = "insuranceEventInContractNumber") InsuranceEventInContractNumber insuranceEventInContractNumber) {
        List<ContractNumber> contractNumbers = contractNumberDatabaseService.getContractNumberByInsuranceEventInContractNumber(insuranceEventInContractNumber);
        return contractNumbers;
    }
    @GetMapping(value = "/contract/find_insurance_event/id/{id}")
    public InsuranceEventInContractNumber getInsuranceEvent(@PathVariable(name = "id") Integer id) {
        return contractNumberDatabaseService.getInsuranceEvent(id);
    }

    @GetMapping(value = "/contract/find/client_id/{clientId}")
    public List<ContractNumber> getContractNumberByClientId(@PathVariable(name = "clientId") Integer clientId) {
        List<ContractNumber> contractNumbers = contractNumberDatabaseService.getContractNumberByClientId(clientId);
        return contractNumbers;
    }

    @GetMapping(value = "/contract/find/id/{id}")
    public Optional<ContractNumber> getContractNumberById(@PathVariable(name = "id") Integer id) {
        Optional<ContractNumber> contractNumber = contractNumberDatabaseService.getContractNumberById(id);
        return contractNumber;
    }

    @PostMapping(value = "/contract/create")
    public ContractNumber createNewContractNumber(@RequestBody ContractNumber contractNumber) {
        contractNumberDatabaseService.create(contractNumber);
        return contractNumber;
    }

    @PutMapping(value = "/contract/update")
    public ContractNumber updateContractNumber(@RequestBody ContractNumber contractNumber) {
        contractNumberDatabaseService.update(contractNumber);
        return contractNumber;
    }

}


