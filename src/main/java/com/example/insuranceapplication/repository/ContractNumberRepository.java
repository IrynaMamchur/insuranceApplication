package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.ContractNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ContractNumberRepository extends JpaRepository<ContractNumber, Integer> {

Collection<ContractNumber> getContractNumbersByIdAfter(int id);

}
