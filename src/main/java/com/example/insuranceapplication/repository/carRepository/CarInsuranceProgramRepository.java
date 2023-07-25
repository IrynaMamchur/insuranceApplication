package com.example.insuranceapplication.repository.carRepository;

import com.example.insuranceapplication.entity.car.CarInsuranceProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarInsuranceProgramRepository extends JpaRepository<CarInsuranceProgram, Integer> {

    /**
     * Finds an CarInsuranceProgram entity from database by insuranceProgramName
     * @param insuranceProgramName The String insuranceProgramName of the CarInsuranceProgram
     * @return CarInsuranceProgram entity from database that was found by the insuranceProgramName of the CarInsuranceProgram
     */
    CarInsuranceProgram getInsuranceProgramByInsuranceProgramName(String insuranceProgramName);


    /**
     * Finds coefficient from database by specified CarInsuranceProgram insuranceProgram
     * @param insuranceProgramName The String insuranceProgramName of the CarInsuranceProgram
     * @return The coefficient from database that was found by the insuranceProgramName of the CarInsuranceProgram
     */
    @Query(value = "SELECT " +
            " carInsuranceProgram.coefficient" +
            " FROM CarInsuranceProgram carInsuranceProgram " +
            "where carInsuranceProgram.insuranceProgramName like :insuranceProgramName ")
    double getCoefficientCarInsuranceProgram(@Param("insuranceProgramName") String insuranceProgramName);
}
