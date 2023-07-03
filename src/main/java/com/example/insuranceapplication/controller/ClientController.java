package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.Client;
import com.example.insuranceapplication.entity.car.CarYearOfIssue;
import com.example.insuranceapplication.entity.enam.ContractInClientStatus;
import com.example.insuranceapplication.service.database.ClientDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientDatabaseService clientDatabaseService;

    @GetMapping(value = "/client/find/name/{name}/{surname}")
    public  ResponseEntity <Client> getClientByName(@PathVariable(name = "name") String name, @PathVariable(name = "surname") String surname) {
        Client client = clientDatabaseService.getClientByName(name, surname);
        return ResponseEntity.ok(client);
    }

    @GetMapping(value = "/client/find/dateOfBirthday/{dateOfBirthday}")
    public ResponseEntity <Client> getClientByDateOfBirthday(@PathVariable(name = "dateOfBirthday") LocalDate dateOfBirthday) {
        Client client = clientDatabaseService.getClientByDateOfBirthday(dateOfBirthday);
        return ResponseEntity.ok(client);
    }

    @GetMapping(value = "/client/find/id/{id}")
    public ResponseEntity <Optional<Client>> getClientById(@PathVariable(name = "id") Integer id) {
        Optional<Client> client = clientDatabaseService.getClientById(id);
        return ResponseEntity.ok(client);
    }

//    @GetMapping(value = "/client/find/status/{contractInClientStatus}")
//    public ResponseEntity <List<Client>> getAllClientByContractStatus(@PathVariable(name = "contractInClientStatus") ContractInClientStatus contractInClientStatus) {
//        List<Client> clients = clientDatabaseService.getAllClientByContractStatus(contractInClientStatus);
//        return clients;
//    }

    @GetMapping(value = "/client/find/all")
    public ResponseEntity <List<Client>> getAllClients() {
        List<Client> clients = clientDatabaseService.getAllClients();
        return createResponseEntity(clients);
    }

    @PostMapping(value = "/client/create")
    public ResponseEntity <Client> createNewClient(@RequestBody Client client) {
        clientDatabaseService.create(client);
        return ResponseEntity.ok(client);
    }

    @PutMapping(value = "/client/update")
    public ResponseEntity <Client> updateClient(@RequestBody Client client) {
        clientDatabaseService.update(client);
        return ResponseEntity.ok(client);
    }

    private ResponseEntity<List<Client>> createResponseEntity(List<Client> clients) {
        if (clients != null && !clients.isEmpty()) {
            return ResponseEntity.ok(clients);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
