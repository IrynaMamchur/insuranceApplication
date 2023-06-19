package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.car.CarYearOfIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CarYearOfIssueRepository extends JpaRepository<CarYearOfIssue, Integer> {
    CarYearOfIssue getYearOfIssueByCarFirstRegistr(LocalDate carFirstRegistr);


}
