package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.Coefficient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CoefficientRepository extends JpaRepository<Coefficient, Integer> {


//    @Query(value = "SELECT " +
//            "CarBrand.coefficient* CarEngineCapacity.coefficient * CarInsuranceProgram.coefficient" +
//            " * CarYearOfIssue.coefficient AS coefficient " +
//            "FROM ClientRequests\n" +
//            "JOIN CarBrand ON ClientRequests.brandId= CarBrand.id \n" +
//            "JOIN CarEngineCapacity ON ClientRequests.engineCapacityId = CarEngineCapacity.id\n" +
//            "JOIN CarInsuranceProgram ON ClientRequests.insuranceProgramId =CarInsuranceProgram.id\n" +
//            "JOIN CarYearOfIssue ON ClientRequests.careFirstRegistrId = CarYearOfIssue.id\n" +
//            " where ClientRequests.id = :id ")
//    ClientRequests createNewCoefficient(@Param("id") Integer id);

    void createCoefficient(Double coefFirst, Double coefSecond, Double coefThird, Double coefFor, Double coefFives);

    @Query(value = "SELECT " +
            "Coefficient .coefficient\n" +
            "FROM Coefficient \n" +
            "where Coefficient .id = :id")
    double getCoefficient (@Param("id") Integer id);

}
