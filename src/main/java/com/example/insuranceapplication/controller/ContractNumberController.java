package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.entity.enam.InsuranceEventInContractNumber;
import com.example.insuranceapplication.service.database.ContractNumberDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ContractNumberController {

    private final ContractNumberDatabaseService contractNumberDatabaseService;


    @GetMapping(value = "/contract/find/amountAll")
    public ResponseEntity <List<ContractNumber>>  getAllContractNumbers() {
        List<ContractNumber> contractNumbers = contractNumberDatabaseService.getAllContractNumbers();
        return createResponseEntity(contractNumbers);
    }

    @GetMapping(value = "/contract/find/id/after/{id}")
    public ResponseEntity <List<ContractNumber>>  getContractNumbersByIdAfter(@PathVariable(name = "id") Integer id) {
        List<ContractNumber> contractNumbers = contractNumberDatabaseService.getContractNumbersByIdAfter(id);
        return createResponseEntity(contractNumbers);
    }

    @GetMapping(value = "/contract/find/finished/after/{finishedAt}")
    public ResponseEntity <List<ContractNumber>>  getContractNumberByFinishedAtAfter(@PathVariable(name = "finishedAt") Timestamp finishedAt) {
        List<ContractNumber> contractNumbers = contractNumberDatabaseService.getContractNumberByFinishedAtAfter(finishedAt);
        return createResponseEntity(contractNumbers);
    }
    @GetMapping(value = "/contract/find/finished/{finishedAt}")
    public ResponseEntity <List<ContractNumber>>  getContractNumberByFinishedAt(@PathVariable(name = "finishedAt") Timestamp finishedAt) {
        List<ContractNumber> contractNumbers = contractNumberDatabaseService.getContractNumberByFinishedAt(finishedAt);
        return createResponseEntity(contractNumbers);
    }

    @GetMapping(value = "/contract/find/started/after/{startedAt}")
    public ResponseEntity <List<ContractNumber>>  getContractNumberByStartedAtAfter(@PathVariable(name = "startedAt") Timestamp startedAt) {
        List<ContractNumber> contractNumbers = contractNumberDatabaseService.getContractNumberByStartedAtAfter(startedAt);
        return createResponseEntity(contractNumbers);
    }

    @GetMapping(value = "/contract/find/started/{startedAt}")
    public ResponseEntity <List<ContractNumber>>  getContractNumberByStartedAt(@PathVariable(name = "startedAt") Timestamp startedAt) {
        List<ContractNumber> contractNumbers = contractNumberDatabaseService.getContractNumberByStartedAt(startedAt);
        return createResponseEntity(contractNumbers);
    }


    @GetMapping(value = "/contract/find/insuranseEvent/{insuranceEventInContractNumber}")
    public ResponseEntity <List<ContractNumber>>  getContractNumberByInsuranceEvent(@PathVariable(name = "insuranceEventInContractNumber") InsuranceEventInContractNumber insuranceEventInContractNumber) {
        List<ContractNumber> contractNumbers = contractNumberDatabaseService.getContractNumberByInsuranceEventInContractNumber(insuranceEventInContractNumber);
        return createResponseEntity(contractNumbers);
    }
    @GetMapping(value = "/contract/findInsuranceEvent/id/{id}")
    public ResponseEntity <InsuranceEventInContractNumber> getInsuranceEvent(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(contractNumberDatabaseService.getInsuranceEvent(id));
    }

//    @GetMapping(value = "/contract/find/clientId/{clientId}")
//    public ResponseEntity <List<ContractNumber>> getContractNumberByClientId(@PathVariable(name = "clientId") Integer clientId) {
//        List<ContractNumber> contractNumbers = contractNumberDatabaseService.getContractNumberByClientId(clientId);
//        return createResponseEntity(contractNumbers);
//    }

    @GetMapping(value = "/contract/find/id/{id}")
    public ResponseEntity <Optional<ContractNumber>>getContractNumberById(@PathVariable(name = "id") Integer id) {
        Optional<ContractNumber> contractNumber = contractNumberDatabaseService.getContractNumberById(id);
        return ResponseEntity.ok(contractNumber);
    }

    @PostMapping(value = "/contract/create")
    public ResponseEntity <ContractNumber> createNewContractNumber(@RequestBody ContractNumber contractNumber) {
        contractNumberDatabaseService.create(contractNumber);
        return ResponseEntity.ok(contractNumber);
    }

    @PutMapping(value = "/contract/update")
    public ResponseEntity <ContractNumber> updateContractNumber(@RequestBody ContractNumber contractNumber) {
        contractNumberDatabaseService.update(contractNumber);
        return ResponseEntity.ok(contractNumber);
    }

    private ResponseEntity<List<ContractNumber>> createResponseEntity(List<ContractNumber> contractNumbers) {
        if (contractNumbers != null && !contractNumbers.isEmpty()) {
            return ResponseEntity.ok(contractNumbers);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}


