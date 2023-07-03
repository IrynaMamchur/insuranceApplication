package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.ClientPassword;
import com.example.insuranceapplication.entity.enam.PasswordStatus;

import java.util.List;
import java.util.Optional;

public interface ClientPasswordDatabaseService {

    ClientPassword getClientPassword(String login, String password);

    List<ClientPassword> getAllClientPasswordsByPasswordStatus(PasswordStatus passwordStatus);

    Optional<ClientPassword> getClientPasswordById(Integer id);

    List<ClientPassword> getAllClientPassword();

    ClientPassword create(ClientPassword clientPassword, String passwort, String login);

    ClientPassword update(ClientPassword clientPassword);

    void creatPassword(String password);

    ClientPassword getClientPasswordByPassword (String password);

    void creatLogin(String login);

    ClientPassword getClientPasswordByLogin (String login);


}




