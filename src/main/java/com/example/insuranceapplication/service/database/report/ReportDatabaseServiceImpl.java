package com.example.insuranceapplication.service.database.report;

import com.example.insuranceapplication.entity.InsurancePayment;
import com.example.insuranceapplication.repository.ReportRepository;
import com.example.insuranceapplication.service.database.ReportDatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReportDatabaseServiceImpl implements ReportDatabaseService {

    private final ReportRepository reportRepository;


    @Override
    public  List<Object> createFirstReport(Double insurancePaymentAmount) {


//        for (Object insurancePayment: reportRepository.createFirstReport(insurancePaymentAmount)) {
//            insurancePayment.getClass().getContractNumber().getId();
//        }


        return reportRepository.createFirstReport(insurancePaymentAmount);
    }
}
