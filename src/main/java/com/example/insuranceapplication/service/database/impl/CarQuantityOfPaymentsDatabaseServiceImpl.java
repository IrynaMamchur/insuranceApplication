package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.car.CarQuantityOfPayments;
import com.example.insuranceapplication.entity.enam.CarQuantityOfPaymentsNumbers;
import com.example.insuranceapplication.repository.CarQuantityOfPaymentsRepository;
import com.example.insuranceapplication.service.database.CarQuantityOfPaymentsDatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarQuantityOfPaymentsDatabaseServiceImpl implements CarQuantityOfPaymentsDatabaseService {

    private final CarQuantityOfPaymentsRepository carQuantityOfPaymentsRepository;

    @Override
    public CarQuantityOfPayments create(CarQuantityOfPayments carQuantityOfPayments) {
        return carQuantityOfPaymentsRepository.save(carQuantityOfPayments);
    }

    @Override
    public CarQuantityOfPayments update(CarQuantityOfPayments carQuantityOfPayments) {
        return carQuantityOfPaymentsRepository.save(carQuantityOfPayments);
    }

    @Override
    public double getCoefficientCarNumberOfPayments(CarQuantityOfPaymentsNumbers number) {
        return carQuantityOfPaymentsRepository.getCoefficientCarNumberOfPayments(number);
    }

}
