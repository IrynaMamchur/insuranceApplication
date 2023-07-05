package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.ClientPassword;
import com.example.insuranceapplication.entity.enam.PasswordStatus;
import com.example.insuranceapplication.service.database.ClientPasswordDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ClientPasswordController {

    private final ClientPasswordDatabaseService clientPasswordDatabaseService;


    @GetMapping(value = "/clientPassword/find/name/{login}/{password}")
    public ResponseEntity <ClientPassword> getClientPassword(@PathVariable(name = "login") String login, @PathVariable(name = "password") String password) {
        ClientPassword clientPassword = clientPasswordDatabaseService.getClientPassword(login, password);
        return ResponseEntity.ok(clientPassword);
    }

    @GetMapping(value = "/clientPassword/find/id/{id}")
    public   ResponseEntity <Optional<ClientPassword>> getClientPasswordById(@PathVariable(name = "id") Integer id) {
        Optional<ClientPassword> clientPassword = clientPasswordDatabaseService.getClientPasswordById(id);
        return ResponseEntity.ok(clientPassword);
    }

    @GetMapping(value = "/clientPassword/find/status/{passwordStatus}")
    public ResponseEntity <List<ClientPassword>> getAllClientByContractStatus(@PathVariable(name = "passwordStatus") PasswordStatus passwordStatus) {
        List<ClientPassword> clientPasswords = clientPasswordDatabaseService.getAllClientPasswordsByPasswordStatus(passwordStatus);
        return createResponseEntity(clientPasswords);
    }

    @GetMapping(value = "/clientPassword/find/all")
    public ResponseEntity <List<ClientPassword>> getAllClientPasswords() {
        List<ClientPassword> clientPasswords = clientPasswordDatabaseService.getAllClientPassword();
        return createResponseEntity(clientPasswords);
    }

    @GetMapping(value = "/clientPassword/find/password/{password}")
    public ResponseEntity <ClientPassword> getClientPasswordByPassword(@PathVariable(name = "password") String password) {
        ClientPassword clientPassword = clientPasswordDatabaseService.getClientPasswordByPassword(password);
        return ResponseEntity.ok(clientPassword);
    }


    @GetMapping(value = "/clientPassword/find/login/{login}")
    public ResponseEntity <ClientPassword> getClientPasswordByLogin(@PathVariable(name = "login") String login) {
        ClientPassword clientPassword = clientPasswordDatabaseService.getClientPasswordByLogin(login);
        return ResponseEntity.ok(clientPassword);
    }


    @PostMapping(value = "/clientPassword/create")
    public ResponseEntity <ClientPassword> createNewClientPassword(@RequestBody ClientPassword clientPassword, String login, String passwort) {
        clientPasswordDatabaseService.create(clientPassword, login, passwort);
        return ResponseEntity.ok(clientPassword);
    }

    @PutMapping(value = "/clientPassword/update")
    public ResponseEntity <ClientPassword> updateClientPassword(@RequestBody ClientPassword clientPassword) {
        clientPasswordDatabaseService.update(clientPassword);
        return ResponseEntity.ok(clientPassword);
    }

    private ResponseEntity<List<ClientPassword>> createResponseEntity(List<ClientPassword> clientPasswords) {
        if (clientPasswords != null && !clientPasswords.isEmpty()) {
            return ResponseEntity.ok(clientPasswords);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
