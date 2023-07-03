package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.enam.CarNumberOfPaymentsNumbers;
import com.example.insuranceapplication.repository.CarNumberOfPaymentsRepository;
import com.example.insuranceapplication.service.database.CarNumberOfPaymentsDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarNumberOfPaymentsDatabaseServiceImpl implements CarNumberOfPaymentsDatabaseService {

    private final CarNumberOfPaymentsRepository carNumberOfPaymentsRepository;
    @Override
    public double getCoefficientCarNumberOfPayments(CarNumberOfPaymentsNumbers number) {
        return carNumberOfPaymentsRepository.getCoefficientCarNumberOfPayments(number);
    }

}
