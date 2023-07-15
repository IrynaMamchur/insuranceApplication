package com.example.insuranceapplication.repository.carRepository;

import com.example.insuranceapplication.entity.car.CarInsuranceProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarInsuranceProgramRepository extends JpaRepository<CarInsuranceProgram, Integer> {

    CarInsuranceProgram getInsuranceProgramByInsuranceProgramName(String insuranceProgramName);

    @Query(value = "SELECT " +
            " carInsuranceProgram.coefficient" +
            " FROM CarInsuranceProgram carInsuranceProgram " +
            "where carInsuranceProgram.insuranceProgramName like :insuranceProgramName ")
    double getCoefficientCarInsuranceProgram(@Param("insuranceProgramName") String insuranceProgramName);
}
