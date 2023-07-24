package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.car.CarBrand;
import com.example.insuranceapplication.entity.updateDto.CarBrandUpdateDto;
import java.util.List;
import java.util.Optional;

public interface CarBrandDatabaseService {
    /**
     * Finds an СarBrand entity from database by car brand and model
     *
     * @param carBrandName The brand and model name of the CarBrand.
     * @return CarBrand entity from database that was found by the brand and model of the CarBrand
     */
    CarBrand getCarBrandByName(String carBrandName);

    /**
     * Finds an СarBrand entity from database by specified CarBrand id
     *
     * @param id The id of the CarBrand.
     * @return CarBrand entity from database that was found by the specified id of the CarBrand
     */
    Optional<CarBrand> getCarBrandById(Integer id);

    /**
     * Finds all СarBrand entity from database
     *
     * @return All CarBrand entity from database
     */
    List<CarBrand> getCarBrands();

    /**
     * Create new CarBrand entity
     *
     * @param carBrand The new CarBrand entity (Integer id,String carBrandName,Double coefficient, Timestamp createdAt,Timestamp finishedAt)
     * @return The new CarBrand entity
     */
    CarBrand create(CarBrand carBrand);

    /**
     * Finds coefficient from database by specified CarBrand brand and model name
     *
     * @param carBrandName The String carBrandName of the CarBrand.
     * @return The coefficient from database that was found by the brand and model name of the CarBrand
     */
    double getCoefficientCarBrand(String carBrandName);

    /**
     * Deletion an СarBrand entity from database by specified CarBrand id
     *
     * @param id The id of the CarBrand.
     */

    void delete(Integer id);

    /**
     * Change one or more parameters in CarBrand entity from database by specified CarBrand id
     *
     * @param id                The id of the CarBrand.
     * @param carBrandUpdateDto The parameters, which need to be replaced (String carBrandName, Double coefficient)
     * @return The CarBrand entity with new parameters
     */
    Optional<CarBrand> updateWithCheck(Integer id, CarBrandUpdateDto carBrandUpdateDto);

}
