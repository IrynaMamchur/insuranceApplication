package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.car.CarEngineCapacity;
import com.example.insuranceapplication.entity.updateDto.CarEngineCapacityUpdateDto;
import com.example.insuranceapplication.repository.carRepository.CarEngineCapacityRepository;
import com.example.insuranceapplication.service.database.CarEngineCapacityDatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarEngineCapacityDatabaseServiceImpl implements CarEngineCapacityDatabaseService {
    private final CarEngineCapacityRepository carEngineCapacityRepository;

    @Override
    public CarEngineCapacity getEngineCapacity(Double engineCapacity) {
        return carEngineCapacityRepository.getEngineCapacityByEngineCapacityEquals(engineCapacity);
    }

    @Override
    public Optional<CarEngineCapacity> getCarEngineCapacityById(Integer id) {
        return carEngineCapacityRepository.findById(id);
    }

    @Override
    public List<CarEngineCapacity> getAllCarEngineCapacity() {
        return carEngineCapacityRepository.findAll();
    }


    @Override
    public CarEngineCapacity create(CarEngineCapacity carEngineCapacity) {
        return carEngineCapacityRepository.save(new CarEngineCapacity());
    }

    @Override
    public CarEngineCapacity update(CarEngineCapacity carEngineCapacity) {
        return carEngineCapacityRepository.save(carEngineCapacity);
    }

    @Override
    public double getCoefficientCarEngineCapacity(Double engineCapacity) {
        return carEngineCapacityRepository.getCoefficientCarEngineCapacity(engineCapacity);
    }

    @Override
    public void delete(Integer id) {
        carEngineCapacityRepository.deleteById(id);
    }

    @Override
    public Optional<CarEngineCapacity> updateWithCheck(Integer id, CarEngineCapacityUpdateDto carEngineCapacityUpdateDto) {
        Optional<CarEngineCapacity> carEngineCapacityOptional = carEngineCapacityRepository.findById(id);
        if (carEngineCapacityOptional.isPresent() && carEngineCapacityUpdateDto != null) {
            CarEngineCapacity carEngineCapacity = carEngineCapacityOptional.get();
            if (carEngineCapacityUpdateDto.getEngineCapacity() != null) {
                carEngineCapacity.setEngineCapacity(carEngineCapacityUpdateDto.getEngineCapacity());
            }
            if (carEngineCapacityUpdateDto.getCoefficient() != null) {
                carEngineCapacity.setCoefficient(carEngineCapacityUpdateDto.getCoefficient());
            }
            carEngineCapacityRepository.save(carEngineCapacity);
            return Optional.of(carEngineCapacity);
        }
        return Optional.empty();
    }

}

