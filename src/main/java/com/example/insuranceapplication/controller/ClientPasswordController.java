package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.Client;
import com.example.insuranceapplication.entity.ClientPassword;
import com.example.insuranceapplication.entity.car.CarBrand;
import com.example.insuranceapplication.entity.enam.ContractInClientStatus;
import com.example.insuranceapplication.entity.enam.PasswordStatus;
import com.example.insuranceapplication.service.database.ClientDatabaseService;
import com.example.insuranceapplication.service.database.ClientPasswordDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ClientPasswordController {

    private final ClientPasswordDatabaseService clientPasswordDatabaseService;


    @GetMapping(value = "/clientPassword/find/name/{login}/{password}")
    public ClientPassword getClientPassword(@PathVariable(name = "login") String login, @PathVariable(name = "password")String password){
        ClientPassword clientPassword = clientPasswordDatabaseService.getClientPassword(login, password);
        return clientPassword;
    }

    @GetMapping(value = "/clientPassword/find/id/{id}")
    public Optional<ClientPassword> getClientPasswordById(@PathVariable(name = "id") Integer id){
        Optional<ClientPassword> clientPassword = clientPasswordDatabaseService.getClientPasswordById(id);
        return clientPassword;
    }
    @GetMapping(value = "/clientPassword/find/status/{passwordStatus}")
    public List<ClientPassword> getAllClientByContractStatus(@PathVariable(name = "passwordStatus") PasswordStatus passwordStatus){
        List<ClientPassword> clientPasswords = clientPasswordDatabaseService.getAllClientPasswordsByPasswordStatus(passwordStatus);
        return clientPasswords;
    }

    @GetMapping(value = "/clientPassword/find/all")
    public List<ClientPassword> getAllClientPasswords(){
        List<ClientPassword> clientPasswords = clientPasswordDatabaseService.getAllClientPassword();
        return clientPasswords;
    }


    @PostMapping(value = "/clientPassword/create")
    public ClientPassword createNewClientPassword(@RequestBody ClientPassword clientPassword) {
        clientPasswordDatabaseService.create(clientPassword);
        return clientPassword;
    }

    @PutMapping(value = "/clientPassword/update")
    public ClientPassword updateClientPassword(@RequestBody ClientPassword clientPassword) {
        clientPasswordDatabaseService.update(clientPassword);
        return clientPassword;
    }

}
