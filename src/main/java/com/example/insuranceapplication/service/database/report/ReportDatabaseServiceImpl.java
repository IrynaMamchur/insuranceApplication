package com.example.insuranceapplication.service.database.report;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.repository.ClientRequestsRepository;
import com.example.insuranceapplication.repository.ContractNumberRepository;
import com.example.insuranceapplication.repository.InsurancePaymentRepository;
import com.example.insuranceapplication.service.database.ReportDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ReportDatabaseServiceImpl implements ReportDatabaseService {

    private final ContractNumberRepository contractNumberRepository;
    private final ClientRequestsRepository clientRequestsRepository;
    private final InsurancePaymentRepository insurancePaymentRepository;


    @Override
    public List<ContractNumber> createFirstReport(Timestamp startedAt) {
        return (List<ContractNumber>) contractNumberRepository.createFirstReport(startedAt);
    }
}
