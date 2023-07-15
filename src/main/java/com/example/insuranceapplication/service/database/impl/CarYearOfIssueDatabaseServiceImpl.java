package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.car.CarYearOfIssue;
import com.example.insuranceapplication.entity.updateDto.CarYearOfIssueUpdateDto;
import com.example.insuranceapplication.repository.carRepository.CarYearOfIssueRepository;
import com.example.insuranceapplication.service.database.CarYearOfIssueDatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarYearOfIssueDatabaseServiceImpl implements CarYearOfIssueDatabaseService {

    private final CarYearOfIssueRepository carYearOfIssueRepository;

    @Override
    public CarYearOfIssue getYearOfIssueByCarFirstRegistr(Integer carFirstRegistr) {
        return carYearOfIssueRepository.getYearOfIssueByCarFirstRegistr(carFirstRegistr);
    }

    @Override
    public Optional<CarYearOfIssue> getCarYearOfIssueById(Integer id) {
        return carYearOfIssueRepository.findById(id);
    }

    @Override
    public List<CarYearOfIssue> getAllCarYearOfIssue() {
        return carYearOfIssueRepository.findAll();
    }

    @Override
    public CarYearOfIssue create(CarYearOfIssue carYearOfIssue) {
        return carYearOfIssueRepository.save(new CarYearOfIssue());
    }

    @Override
    public double getCoefficientCarYearOfIssue(Integer carFirstRegistr) {
        return carYearOfIssueRepository.getCoefficientCarYearOfIssue(carFirstRegistr);
    }

    @Override
    public void delete(Integer id) {
        carYearOfIssueRepository.deleteById(id);
    }

    @Override
    public Optional<CarYearOfIssue> updateWithCheck(Integer id, CarYearOfIssueUpdateDto carYearOfIssueUpdateDto) {
        Optional<CarYearOfIssue> carYearOfIssueOptional = carYearOfIssueRepository.findById(id);
        if (carYearOfIssueOptional.isPresent() && carYearOfIssueUpdateDto != null) {
            CarYearOfIssue carYearOfIssue = carYearOfIssueOptional.get();
            if (carYearOfIssueUpdateDto.getCarFirstRegistr() != null) {
                carYearOfIssue.setCarFirstRegistr(carYearOfIssueUpdateDto.getCarFirstRegistr());
            }
            if (carYearOfIssueUpdateDto.getCoefficient() != null) {
                carYearOfIssue.setCoefficient(carYearOfIssueUpdateDto.getCoefficient());
            }
            carYearOfIssueRepository.save(carYearOfIssue);
            return Optional.of(carYearOfIssue);
        }
        return Optional.empty();
    }
}
