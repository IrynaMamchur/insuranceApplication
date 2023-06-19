package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.Client;
import com.example.insuranceapplication.entity.ClientPassword;
import com.example.insuranceapplication.entity.enam.ContractInClientStatus;
import com.example.insuranceapplication.entity.enam.PasswordStatus;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ClientPasswordDatabaseService {

    ClientPassword getClientPassword(String login, String password);

    List<ClientPassword> getAllClientPasswordsByPasswordStatus(PasswordStatus passwordStatus);
    Optional<ClientPassword> getClientPasswordById(Integer id);

    List<ClientPassword> getAllClientPassword();

    ClientPassword create(ClientPassword clientPassword);

    ClientPassword update(ClientPassword clientPassword);
}




