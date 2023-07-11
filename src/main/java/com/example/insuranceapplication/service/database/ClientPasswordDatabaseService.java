package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.ClientPassword;
import com.example.insuranceapplication.entity.enam.PasswordStatus;
import com.example.insuranceapplication.entity.updateDto.ClientPasswordUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ClientPasswordDatabaseService {

    ClientPassword getClientPassword(String login, String password);

    List<ClientPassword> getAllClientPasswordsByPasswordStatus(PasswordStatus passwordStatus);

    Optional<ClientPassword> getClientPasswordById(Integer id);

    List<ClientPassword> getAllClientPassword();

    ClientPassword create(ClientPassword clientPassword);

    ClientPassword update(ClientPassword clientPassword);

    void verificationPassword(String password);

    ClientPassword getClientPasswordByPassword(String password);

    void verificationLogin(String login);

    ClientPassword getClientPasswordByLogin(String login);

    void delete(Integer id);

    Optional<ClientPassword> updateWithCheck(Integer id, ClientPasswordUpdateDto clientPasswordUpdateDto);

}




