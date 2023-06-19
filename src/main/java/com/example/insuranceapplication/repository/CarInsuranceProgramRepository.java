package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.car.CarInsuranceProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarInsuranceProgramRepository extends JpaRepository<CarInsuranceProgram, Integer> {

    CarInsuranceProgram getInsuranceProgramByInsuranceProgramName(String insuranceProgramName);

}
