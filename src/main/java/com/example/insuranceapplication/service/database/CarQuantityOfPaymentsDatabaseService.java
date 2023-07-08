package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.car.CarQuantityOfPayments;
import com.example.insuranceapplication.entity.enam.CarQuantityOfPaymentsNumbers;
import com.example.insuranceapplication.entity.updateDto.CarQuantityOfPaymentUpdateDto;

import java.util.Optional;

public interface CarQuantityOfPaymentsDatabaseService {
    CarQuantityOfPayments create(CarQuantityOfPayments carQuantityOfPayments);

    CarQuantityOfPayments update(CarQuantityOfPayments carQuantityOfPayments);

    double getCoefficientCarNumberOfPayments(CarQuantityOfPaymentsNumbers number);

    void delete(Integer id);

    Optional<CarQuantityOfPayments> updateWithCheck(Integer id, CarQuantityOfPaymentUpdateDto carQuantityOfPaymentUpdateDto);

}
