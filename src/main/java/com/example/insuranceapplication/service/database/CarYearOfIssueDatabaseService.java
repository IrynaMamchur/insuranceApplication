package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.car.CarYearOfIssue;
import com.example.insuranceapplication.entity.updateDto.CarYearOfIssueUpdateDto;

import java.util.List;
import java.util.Optional;

public interface CarYearOfIssueDatabaseService {

    /**
     * Finds an CarYearOfIssue entity from database by carFirstRegistr
     * @param carFirstRegistr The Integer carFirstRegistr of the CarYearOfIssue
     * @return CarYearOfIssue entity from database that was found by the carFirstRegistr of the CarYearOfIssue
     */
    CarYearOfIssue getYearOfIssueByCarFirstRegistr(Integer carFirstRegistr);

    /**
     * Finds an CarYearOfIssue entity from database by specified CarYearOfIssue id
     * @param id  The id of the CarYearOfIssue
     * @return CarYearOfIssue entity from database that was found by the specified CarYearOfIssue id
     */
    Optional<CarYearOfIssue> getCarYearOfIssueById(Integer id);

    /**
     * Finds all CarYearOfIssue entity from database
     * @return All CarYearOfIssue entity from database
     */
    List<CarYearOfIssue> getAllCarYearOfIssue();

    /**
     * Create new CarYearOfIssue entity
     * @param carYearOfIssue The CarYearOfIssue entity (Integer id, Integer carFirstRegistr, Double coefficient, Timestamp createdAt, Timestamp finishedAt)
     * @return The new CarYearOfIssue entity
     */
    CarYearOfIssue create(CarYearOfIssue carYearOfIssue);

    /**
     * Finds coefficient from database by specified CarYearOfIssue carFirstRegistr
     * @param carFirstRegistr The Integer carFirstRegistr of the CarYearOfIssue
     * @return The coefficient from database that was found by the carFirstRegistr of the CarYearOfIssue
     */
    double getCoefficientCarYearOfIssue(Integer carFirstRegistr);

    /**
     * Deletion an CarYearOfIssue entity from database by specified CarYearOfIssue id
     * @param id The id of the CarYearOfIssue
     */
    void delete(Integer id);

    /**
     * Change one or more parameters in CarYearOfIssue entity from database by specified CarYearOfIssue id
     * @param id The id of the CarYearOfIssue
     * @param carYearOfIssueUpdateDto  The parameters, which need to be replaced (Integer carFirstRegistr, Double coefficient)
     * @return  The CarYearOfIssue entity with new parameters
     */
    Optional<CarYearOfIssue> updateWithCheck(Integer id, CarYearOfIssueUpdateDto carYearOfIssueUpdateDto);
}





