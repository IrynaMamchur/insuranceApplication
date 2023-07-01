package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.car.CarInsuranceProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarInsuranceProgramRepository extends JpaRepository<CarInsuranceProgram, Integer> {

    CarInsuranceProgram getInsuranceProgramByInsuranceProgramName(String insuranceProgramName);

    @Query(value = "SELECT " +
            "CarInsuranceProgram.coefficient\n" +
            "FROM CarInsuranceProgram \n" +
            "where CarInsuranceProgram .insuranceProgramName = :insuranceProgramName ", nativeQuery = true)
    double getCoefficientCarInsuranceProgram(@Param("insuranceProgramName") String insuranceProgramName);
}
