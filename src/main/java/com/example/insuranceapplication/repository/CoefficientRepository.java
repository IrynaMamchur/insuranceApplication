package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.Coefficient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CoefficientRepository extends JpaRepository<Coefficient, Integer> {

    void createNewCoefficient(double coefCarBrand, double coefCarEngineCapacity, double coefCarInsuranceProgram, double coefCarYearOfIssue, double coefCarQuantityOfPayments);

    @Query(value = "SELECT " +
            "Coefficient .coefficient\n" +
            "FROM Coefficient \n" +
            "where Coefficient .id = :id", nativeQuery = true)
    double getCoefficient (@Param("id") Integer id);

}
