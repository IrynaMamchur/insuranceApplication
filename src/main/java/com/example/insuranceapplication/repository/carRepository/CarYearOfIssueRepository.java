package com.example.insuranceapplication.repository.carRepository;

import com.example.insuranceapplication.entity.car.CarYearOfIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarYearOfIssueRepository extends JpaRepository<CarYearOfIssue, Integer> {
    CarYearOfIssue getYearOfIssueByCarFirstRegistr(Integer carFirstRegistr);

    @Query(value = "SELECT " +
            " carYearOfIssue.coefficient" +
            " FROM CarYearOfIssue carYearOfIssue" +
            " where carYearOfIssue.carFirstRegistr = :carFirstRegistr ")
    double getCoefficientCarYearOfIssue(@Param("carFirstRegistr") Integer carFirstRegistr);
}
