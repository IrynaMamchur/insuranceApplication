package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.entity.enam.InsuranceEventInContractNumber;
import com.example.insuranceapplication.entity.updateDto.ContractNumberUpdateDto;
import com.example.insuranceapplication.repository.ContractNumberRepository;
import com.example.insuranceapplication.service.database.ContractNumberDatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
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

    @Override
    public List<ContractNumber> getContractNumberByFinishedAtAfter(Timestamp finishedAt) {
        return (List<ContractNumber>) contractNumberRepository.getContractNumberByFinishedAtAfter(finishedAt);
    }

    @Override
    public List<ContractNumber> getContractNumberByFinishedAt(Timestamp finishedAt) {
        return (List<ContractNumber>) contractNumberRepository.getContractNumberByFinishedAt(finishedAt);
    }

    @Override
    public List<ContractNumber> getContractNumberByStartedAtAfter(Timestamp startedAt) {
        return (List<ContractNumber>) contractNumberRepository.getContractNumberByStartedAtAfter(startedAt);
    }

    @Override
    public List<ContractNumber> getContractNumberByStartedAt(Timestamp startedAt) {
        return (List<ContractNumber>) contractNumberRepository.getContractNumberByStartedAt(startedAt);
    }


    public Optional<ContractNumber> getContractNumberById(Integer id) {
        return contractNumberRepository.findById(id);
    }

    @Override
    public ContractNumber create(ContractNumber contractNumber) {
        return contractNumberRepository.save(contractNumber);
    }

    @Override
    public InsuranceEventInContractNumber getInsuranceEvent(Integer id) {
        return contractNumberRepository.getInsuranceEvent(id);
    }

    @Override
    public List<ContractNumber> getAllContractNumbers() {
        return contractNumberRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        contractNumberRepository.deleteById(id);
    }

    @Override
    public Optional<ContractNumber> updateWithCheck(Integer id, ContractNumberUpdateDto contractNumberUpdateDto) {
        Optional<ContractNumber> contractNumberOptional = contractNumberRepository.findById(id);
        if (contractNumberOptional.isPresent() && contractNumberUpdateDto != null) {
            ContractNumber contractNumber = contractNumberOptional.get();
            if (contractNumberUpdateDto.getInsuranceEventInContractNumber() != null) {
                contractNumber.setInsuranceEventInContractNumber(InsuranceEventInContractNumber.valueOf(contractNumberUpdateDto.getInsuranceEventInContractNumber()));
            }
            if (contractNumberUpdateDto.getStartedAt() != null) {
                contractNumber.setStartedAt(contractNumberUpdateDto.getStartedAt());
            }
            if (contractNumberUpdateDto.getFinishedAt() != null) {
                contractNumber.setFinishedAt(contractNumberUpdateDto.getFinishedAt());
            }
            contractNumberRepository.save(contractNumber);
            return Optional.of(contractNumber);
        }
        return Optional.empty();
    }
}
