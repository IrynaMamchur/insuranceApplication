package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.car.CarInsuranceProgram;
import com.example.insuranceapplication.entity.car.CarQuantityOfPayments;
import com.example.insuranceapplication.entity.enam.CarQuantityOfPaymentsNumbers;

public interface CarQuantityOfPaymentsDatabaseService {
    CarQuantityOfPayments create(CarQuantityOfPayments carQuantityOfPayments);

    CarQuantityOfPayments update(CarQuantityOfPayments carQuantityOfPayments);

    double getCoefficientCarNumberOfPayments(CarQuantityOfPaymentsNumbers number);
}
