package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.Client;
import com.example.insuranceapplication.entity.car.CarBrand;
import com.example.insuranceapplication.entity.car.CarYearOfIssue;
import com.example.insuranceapplication.entity.enam.ContractInClientStatus;
import com.example.insuranceapplication.service.database.ClientDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientDatabaseService clientDatabaseService;

    @GetMapping(value = "/client/find/name/{name}/{surname}")
    public Client getClientByName(@PathVariable(name = "name") String name, @PathVariable(name = "surname")String surname){
        Client client = clientDatabaseService.getClientByName(name, surname);
        return client;
    }
    @GetMapping(value = "/client/find/date_of_birthday/{dateOfBirthday}")
    public Client getClientByDateOfBirthday(@PathVariable(name = "dateOfBirthday")LocalDate dateOfBirthday){
        Client client = clientDatabaseService.getClientByDateOfBirthday(dateOfBirthday);
        return client;
    }

    @GetMapping(value = "/client/find/id/{id}")
    public Optional<Client> getClientById(@PathVariable(name = "id") Integer id){
        Optional<Client> client = clientDatabaseService.getClientById(id);
        return client;
    }

  @GetMapping(value = "/client/find/status/{contractInClientStatus}")
    public List<Client> getAllClientByContractStatus(@PathVariable(name = "contractInClientStatus") ContractInClientStatus contractInClientStatus){
        List<Client> clients = clientDatabaseService .getAllClientByContractStatus(contractInClientStatus);
        return clients;
    }

    @GetMapping(value = "/client/find/all")
    public List<Client> getAllClients(){
        List<Client> clients = clientDatabaseService .getAllClients();
        return clients;
    }

    @PostMapping(value = "/client/create")
    public Client createNewClient(@RequestBody Client client) {
        clientDatabaseService.create(client);
        return client;
    }

    @PutMapping(value = "/client/update")
    public Client updateClient(@RequestBody Client client) {
        clientDatabaseService.update(client);
        return client;
    }

}
