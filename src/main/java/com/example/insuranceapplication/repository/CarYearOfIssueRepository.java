package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.car.EngineCapacity;
import com.example.insuranceapplication.entity.car.YearOfIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarYearOfIssueRepository extends JpaRepository<YearOfIssue, Integer> {
}
