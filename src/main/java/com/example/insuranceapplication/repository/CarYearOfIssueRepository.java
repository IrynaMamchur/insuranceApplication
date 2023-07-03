package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.car.CarYearOfIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CarYearOfIssueRepository extends JpaRepository<CarYearOfIssue, Integer> {
    CarYearOfIssue getYearOfIssueByCarFirstRegistr(Integer carFirstRegistr);

    @Query(value = "SELECT " +
            "CarYearOfIssue .coefficient\n" +
            "FROM CarYearOfIssue  \n" +
            "where CarYearOfIssue .carFirstRegistr = :carFirstRegistr ", nativeQuery = true)
    double getCoefficientCarYearOfIssue(@Param("carFirstRegistr") Integer carFirstRegistr);
}
