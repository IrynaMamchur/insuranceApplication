package com.example.insuranceapplication.service.database.report;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.repository.ReportRepository;
import com.example.insuranceapplication.service.database.ReportDatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReportDatabaseServiceImpl implements ReportDatabaseService {

    private final ReportRepository reportRepository;

    @Override
    public List<ContractNumber> createFirstReport(Timestamp startedAt) {
        return (List<ContractNumber>) reportRepository.createFirstReport(startedAt);
    }
}
