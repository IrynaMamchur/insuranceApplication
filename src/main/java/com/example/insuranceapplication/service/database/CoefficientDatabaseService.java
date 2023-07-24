package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.Coefficient;
import com.example.insuranceapplication.entity.dto.CoefficientDto;
import com.example.insuranceapplication.entity.updateDto.CoefficientUpdateDto;

import java.util.Optional;

public interface CoefficientDatabaseService {

    /**Calculation of the final coefficient required to calculate the insurance payment
     * @param carBrandName  The brand and model name of the CarBrand.
     * @param engineCapacity The Double engineCapacity of the CarEngineCapacity
     * @param insuranceProgramName  The String insuranceProgramName of the CarInsuranceProgram
     * @param carFirstRegistr  The Integer carFirstRegistr of the CarYearOfIssue
     * @param number  The Integer number of the CarQuantityOfPayments
     * @return  The final coefficient required to calculate the insurance payment
     */
    double createCoefficient(String carBrandName, Double engineCapacity, String insuranceProgramName, Integer carFirstRegistr, Integer number);

    /**
     * Find coefficient from database by specified Coefficient id
     * @param id The id of the Coefficient
     * @return  The coefficient from database by specified Coefficient id
     */
    double getCoefficientCoefficient(Integer id);

    /**
     * Create new Coefficient entity
     * @param coefficient  new Coefficient entity(Integer id, Integer carBrandId, Integer carEngineCapacityId,Integer carInsuranceProgramId, Integer carYearOfIssueId,Double coefficientForCar,Timestamp createdAt, Timestamp createdAt)
     * @return The new Coefficient entity
     */
    Coefficient create(Coefficient coefficient);

    /**
     * Change coefficient in Coefficient entity from database by specified Coefficient id
     * @param coefficientDto The parameters, which need to be replaced(Integer id, String carBrandName, Double engineCapacity, String insuranceProgramName,Integer carFirstRegistr, Integer number)
     * @return   The Coefficient entity with new parameters
     */
    Optional<Coefficient> updateCoefficientForCar(CoefficientDto coefficientDto);

    /**
     * Deletion an Сoefficient entity from database by specified Coefficient id
     * @param id   The id of the Coefficient
     */
    void delete(Integer id);

    /**
     * Change one or more parameters in Coefficient entity from database by specified Coefficient id
     * @param id  The id of the Coefficient
     * @param coefficientUpdateDto  The parameters, which need to be replaced(Integer carBrandId, Integer carEngineCapacityId,Integer carInsuranceProgramId, Integer carYearOfIssueId,Double coefficientForCar, Integer carQuantityOfPaymentsId)
     * @return The Coefficient entity with new parameters
     */
    Optional<Coefficient> updateWithCheck(Integer id, CoefficientUpdateDto coefficientUpdateDto);

    /**
     * Finds an Сoefficient entity from database by specified Coefficient id
     * @param id  The id of the Coefficient
     * @return  Coefficient entity from database that was found by the specified id of the Coefficient
     */
    Optional<Coefficient> getCoefficientById(Integer id);
}
