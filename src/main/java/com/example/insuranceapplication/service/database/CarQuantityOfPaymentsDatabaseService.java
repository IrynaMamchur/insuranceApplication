package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.car.CarQuantityOfPayments;
import com.example.insuranceapplication.entity.updateDto.CarQuantityOfPaymentUpdateDto;

import java.util.List;
import java.util.Optional;

public interface CarQuantityOfPaymentsDatabaseService {

    /**
     * Create new CarQuantityOfPayments entity
     * @param carQuantityOfPayments The CarQuantityOfPayments entity (Integer id, CarQuantityOfPaymentsNumbers number, Double coefficient, Timestamp createdAt, Timestamp finishedAt,
     * @return The new CarQuantityOfPayments entity
     */
    CarQuantityOfPayments create(CarQuantityOfPayments carQuantityOfPayments);

    /**
     * Finds all CarQuantityOfPayments entity from database
     * @return All CarQuantityOfPayments entity from database
     */

    List<CarQuantityOfPayments> getAllCarQuantityOfPayments();

    /**
     * Finds coefficient from database by specified CarQuantityOfPayments number
     * @param number The Integer number of the CarQuantityOfPayments
     * @return The coefficient from database that was found by the specified CarQuantityOfPayments number of the CarQuantityOfPayments
     */
    double getCoefficientCarNumberOfPayments(Integer number);

    /**
     * Deletion an CarQuantityOfPayments entity from database by specified CarQuantityOfPayments id
     *
     * @param id The id of the CarQuantityOfPayments
     */
    void delete(Integer id);

    /**
     * Change one or more parameters in CarQuantityOfPayments entity from database by specified CarQuantityOfPayments id
     *
     * @param id                            The id of the CarQuantityOfPayments
     * @param carQuantityOfPaymentUpdateDto The parameters, which need to be replaced(String number, Double coefficient)
     * @return The CarQuantityOfPayments entity with new parameters
     */
    Optional<CarQuantityOfPayments> updateWithCheck(Integer id, CarQuantityOfPaymentUpdateDto carQuantityOfPaymentUpdateDto);

    /**
     * Finds an CarQuantityOfPayments entity from database by specified CarQuantityOfPayments id
     * @param id  The id of the CarQuantityOfPayments
     * @return  CarQuantityOfPayments entity from database that was found by the specified CarQuantityOfPayments id
     */
    Optional<CarQuantityOfPayments> getCarQuantityOfPaymentsByID(Integer id);
}
