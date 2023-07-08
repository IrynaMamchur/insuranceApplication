package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.car.CarQuantityOfPayments;
import com.example.insuranceapplication.entity.enam.CarQuantityOfPaymentsNumbers;
import com.example.insuranceapplication.entity.updateDto.CarQuantityOfPaymentUpdateDto;
import com.example.insuranceapplication.repository.carRepository.CarQuantityOfPaymentsRepository;
import com.example.insuranceapplication.service.database.CarQuantityOfPaymentsDatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public void delete(Integer id) {
        carQuantityOfPaymentsRepository.deleteById(id);
    }


    @Override
    public Optional<CarQuantityOfPayments> updateWithCheck(Integer id, CarQuantityOfPaymentUpdateDto carQuantityOfPaymentUpdateDto) {
        Optional<CarQuantityOfPayments> carQuantityOfPaymentsOptional = carQuantityOfPaymentsRepository.findById(id);
        if (carQuantityOfPaymentsOptional.isPresent() && carQuantityOfPaymentUpdateDto != null) {
            CarQuantityOfPayments carQuantityOfPayments = carQuantityOfPaymentsOptional.get();
            if (carQuantityOfPaymentUpdateDto.getNumber() != null) {
                carQuantityOfPayments.setNumber(carQuantityOfPaymentUpdateDto.getNumber());
            }
            if (carQuantityOfPaymentUpdateDto.getCoefficient() != null) {
                carQuantityOfPayments.setCoefficient(carQuantityOfPaymentUpdateDto.getCoefficient());
            }
            carQuantityOfPaymentsRepository.save(carQuantityOfPayments);
            return Optional.of(carQuantityOfPayments);
        }
        return Optional.empty();
    }

}
