package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.entity.enam.InsuranceEventInContractNumber;
import com.example.insuranceapplication.repository.ContractNumberRepository;
import com.example.insuranceapplication.service.database.ContractNumberDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContractNumberDatabaseServiceImpl implements ContractNumberDatabaseService {
    private final ContractNumberRepository contractNumberRepository;


    @Override
    public List<ContractNumber> getContractNumbersByIdAfter(Integer id) {
        return (List<ContractNumber>) contractNumberRepository.getContractNumbersByIdAfter(id);
    }

    @Override
    public List<ContractNumber> getContractNumberByInsuranceEventInContractNumber(InsuranceEventInContractNumber insuranceEventInContractNumber) {
        return (List<ContractNumber>) contractNumberRepository.getContractNumberByInsuranceEventInContractNumber(insuranceEventInContractNumber);
    }

//    @Override
//    public List<ContractNumber> getContractNumberByFinishedAtAfter(Timestamp finishedAt) {
//        return (List<ContractNumber>) contractNumberRepository.getContractNumberByFinishedAtAfter(finishedAt);
//    }
//
//    @Override
//    public List<ContractNumber> getContractNumberByFinishedAt(Timestamp finishedAt) {
//        return null;
//    }
//
//    @Override
//    public List<ContractNumber> getContractNumberByStartedAtAfter(Timestamp startedAt) {
//        return null;
//    }
//
//    @Override
//    public List<ContractNumber> getContractNumberByStartedAt(Timestamp startedAt) {
//        return null;
//    }

    @Override
    public List<ContractNumber> getContractNumberByAmountAll(Double amountAll) {
        return (List<ContractNumber>) contractNumberRepository.getContractNumberByAmountAll(amountAll);
    }


    public List<ContractNumber> getContractNumberByClientId(Integer clientId) {
        return (List<ContractNumber>) contractNumberRepository.getContractNumberByClientId(clientId);
    }

    public Optional<ContractNumber> getContractNumberById(Integer id) {
        return contractNumberRepository.findById(id);
    }

    @Override
    public ContractNumber create(ContractNumber contractNumber) {
        return contractNumberRepository.save(new ContractNumber());
    }

    @Override
    public ContractNumber update(ContractNumber contractNumber) {
        return contractNumberRepository.save(contractNumber);
    }

    @Override
    public List<ContractNumber> getAllContractNumbers() {
        return contractNumberRepository.findAll();
    }
}
