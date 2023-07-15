package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.car.CarEngineCapacity;
import com.example.insuranceapplication.entity.updateDto.CarEngineCapacityUpdateDto;

import java.util.List;
import java.util.Optional;

public interface CarEngineCapacityDatabaseService {

 /**
  * Finds an СarEngineCapacity entity from database by engineCapacity
  *
  * @param engineCapacity The Double engineCapacity of the CarEngineCapacity
  * @return CarEngineCapacity entity from database that was found by the engineCapacity of the CarEngineCapacity
  */
 CarEngineCapacity getEngineCapacity(Double engineCapacity);

 /**
  * Finds an СarEngineCapacity entity from database by specified СarEngineCapacity id
  *
  * @param id The id of the СarEngineCapacity
  * @return CarEngineCapacity entity from database that was found by the specified СarEngineCapacity id
  */
 Optional<CarEngineCapacity> getCarEngineCapacityById(Integer id);

 /**
  * Finds all CarEngineCapacity entity from database
  *
  * @return All CarEngineCapacity entity from database
  */
 List<CarEngineCapacity> getAllCarEngineCapacity();

 /**
  * Create new CarEngineCapacity entity
  *
  * @param carEngineCapacity The new CarEngineCapacity entity (Integer id, Double engineCapacity,Double coefficient, Timestamp createdAt, Timestamp finishedAt)
  * @return The new CarEngineCapacity entity
  */
 CarEngineCapacity create(CarEngineCapacity carEngineCapacity);

 /**
  * Finds coefficient from database by specified CarEngineCapacity engineCapacity
  *
  * @param engineCapacity The engineCapacity of the CarEngineCapacity
  * @return The coefficient from database that was found by the engineCapacity of the CarEngineCapacity
  */
 double getCoefficientCarEngineCapacity(Double engineCapacity);

 /**
  * Deletion an CarEngineCapacity entity from database by specified CarEngineCapacity id
  *
  * @param id The id of the СarEngineCapacity
  */
 void delete(Integer id);

 /**
  * Change one or more parameters in CarEngineCapacity entity from database by specified CarEngineCapacity id
  *
  * @param id                         The id of the СarEngineCapacity
  * @param carEngineCapacityUpdateDto The parameters, which need to be replaced (Double engineCapacity, Double coefficient)
  * @return The CarEngineCapacity entity with new parameters
  */

 Optional<CarEngineCapacity> updateWithCheck(Integer id, CarEngineCapacityUpdateDto carEngineCapacityUpdateDto);

}
