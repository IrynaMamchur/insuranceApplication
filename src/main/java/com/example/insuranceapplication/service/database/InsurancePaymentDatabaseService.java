package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.InsurancePayment;
import com.example.insuranceapplication.entity.dto.InsurancePaymentDto;
import com.example.insuranceapplication.entity.updateDto.InsurancePaymentUpdateDto;

import java.util.Optional;

public interface InsurancePaymentDatabaseService {

    /**
     * Create new InsurancePayment entity
     * @param insurancePayment  new InsurancePayment entity(Integer id, Integer coefficientId, Double insurancePaymentAmount,Timestamp createdAt, Double carCost)
     * @return The new InsurancePayment entity
     */
    InsurancePayment create(InsurancePayment insurancePayment);

    /**
     * Calculation of the final insurance payment
     * @param coefficientId The id of the Coefficient
     * @param carCost   The cost of car of the InsurancePayment
     * @return The final insurance payment
     */

    double createInsurancePayment(Integer coefficientId, Double carCost);

    /**
     * Find insurance payment from database by specified InsurancePayment id
     * @param id  The id of the InsurancePayment
     * @return The insurance payment from database by specified InsurancePayment id
     */
    double getAmount(Integer id);

    /**
     * Change insurance payment in InsurancePayment entity from database by specified InsurancePayment id
     * @param insurancePaymentDto  The parameters, which need to be replaced(Integer id,Integer coefficientId, Double carCost)
     * @return  The InsurancePayment entity with new parameters
     */

    Optional<InsurancePayment> updateInsurancePayment(InsurancePaymentDto insurancePaymentDto);


    /**
     * Deletion an InsurancePayment entity from database by specified InsurancePayment id
     * @param id  The id of the InsurancePayment
     */
    void delete(Integer id);

    /**
     * Change one or more parameters in InsurancePayment entity from database by specified InsurancePayment id
     * @param id  The id of the InsurancePayment
     * @param insurancePaymentUpdateDto   The parameters, which need to be replaced(Integer coefficientId, Double insurancePaymentAmount)
     * @return  The InsurancePayment entity with new parameters
     */
    Optional<InsurancePayment> updateWithCheck(Integer id, InsurancePaymentUpdateDto insurancePaymentUpdateDto);

    /**
     * Finds an InsurancePayment entity from database by specified InsurancePayment id
     * @param id  The id of the InsurancePayment
     * @return  The InsurancePayment entity from database that was found by specified InsurancePayment id
     */
    Optional<InsurancePayment> getInsurancePaymentById(Integer id);
}
