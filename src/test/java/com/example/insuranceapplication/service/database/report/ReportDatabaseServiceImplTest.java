package com.example.insuranceapplication.service.database.report;

import com.example.insuranceapplication.repository.ReportRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ReportDatabaseServiceImplTest {

    @Mock
    private ReportRepository reportRepository;
    private ReportDatabaseServiceImpl underTest;

    @InjectMocks
    ReportDatabaseServiceImpl reportDatabaseService;


    @Test
    void createFirstReport() {

    }

}