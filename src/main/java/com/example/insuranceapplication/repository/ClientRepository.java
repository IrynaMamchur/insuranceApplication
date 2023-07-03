package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.Client;
import com.example.insuranceapplication.entity.car.CarBrand;
import com.example.insuranceapplication.entity.enam.ContractInClientStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client getClientByNameAndSurname(String name, String surname);

    Client getClientByDateOfBirthday(LocalDate dateOfBirthday);

    Collection<Client> getClientsByContractInClientStatus(ContractInClientStatus contractInClientStatus);

}
