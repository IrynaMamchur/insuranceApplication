package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.car.CarInsuranceProgram;
import com.example.insuranceapplication.entity.updateDto.CarInsuranceProgramUpdateDto;

import java.util.List;
import java.util.Optional;

public interface CarInsuranceProgramDatabaseService {

    /**
     * Finds an CarInsuranceProgram entity from database by insuranceProgramName
     *
     * @param insuranceProgramName The String insuranceProgramName of the CarInsuranceProgram
     * @return CarInsuranceProgram entity from database that was found by the insuranceProgramName of the CarInsuranceProgram
     */
    CarInsuranceProgram getInsuranceProgramByName(String insuranceProgramName);

    /**
     * Finds an CarInsuranceProgram entity from database by specified CarInsuranceProgram id
     *
     * @param id The id of the CarInsuranceProgram
     * @return CarInsuranceProgram entity from database that was found by the specified CarInsuranceProgram id
     */
    Optional<CarInsuranceProgram> getInsuranceProgramById(Integer id);

    /**
     * Finds all CarInsuranceProgram entity from database
     *
     * @return All CarInsuranceProgram entity from database
     */
    List<CarInsuranceProgram> getAllInsuranceProgram();

    /**
     * Create new CarInsuranceProgram entity
     *
     * @param carInsuranceProgram The CarInsuranceProgram entity (Integer id, String insuranceProgramName, Double coefficient, Timestamp createdAt, Timestamp finishedAt, String optional)
     * @return The new CarInsuranceProgram entity
     */
    CarInsuranceProgram create(CarInsuranceProgram carInsuranceProgram);

    /**
     * Finds coefficient from database by specified CarInsuranceProgram insuranceProgram
     *
     * @param insuranceProgramName The String insuranceProgramName of the CarInsuranceProgram
     * @return The coefficient from database that was found by the insuranceProgramName of the CarInsuranceProgram
     */
    double getCoefficientCarInsuranceProgram(String insuranceProgramName);

    /**
     * Deletion an CarInsuranceProgram entity from database by specified CarInsuranceProgram id
     *
     * @param id The id of the CarInsuranceProgram
     */
    void delete(Integer id);

    /**
     * Change one or more parameters in CarInsuranceProgram entity from database by specified CarInsuranceProgram id
     *
     * @param id                           The id of the CarInsuranceProgram
     * @param carInsuranceProgramUpdateDto The parameters, which need to be replaced (String insuranceProgramName;Double coefficient)
     * @return The CarInsuranceProgram entity with new parameters
     */
    Optional<CarInsuranceProgram> updateWithCheck(Integer id, CarInsuranceProgramUpdateDto carInsuranceProgramUpdateDto);

}
