package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.InsurancePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsurancePaymentRepository extends JpaRepository<InsurancePayment, Integer> {

//    double createInsurancePayment(Double coefForCar, Double carCost);
}
