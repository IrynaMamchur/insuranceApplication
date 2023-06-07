package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.ClientPassword;
import com.example.insuranceapplication.entity.car.EngineCapacity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientPasswordRepository extends JpaRepository<ClientPassword, Integer> {
}
