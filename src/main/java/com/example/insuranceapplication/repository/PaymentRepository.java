package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

//    Collection<Payment> getPaymentsByContractNumberId(Integer contractNumberId);

    Collection<Payment> getPaymentsByAmount(Integer amount);
    @Query(value = "SELECT " +
            "Payment .id\n" +
            "FROM Payment \n" +
            "where Payment .id = :id", nativeQuery = true)
    double getPaymentId (@Param("id") Integer id);

}
