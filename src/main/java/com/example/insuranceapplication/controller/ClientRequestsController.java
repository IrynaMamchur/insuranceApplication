package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.ClientPassword;
import com.example.insuranceapplication.entity.ClientRequests;
import com.example.insuranceapplication.entity.Coefficient;
import com.example.insuranceapplication.entity.enam.ClientRequestStatus;
import com.example.insuranceapplication.service.database.ClientReguestsDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ClientRequestsController {

    private final ClientReguestsDatabaseService clientReguestsDatabaseService;

    @GetMapping(value = "/clientReguests/find/status/{clientRequestStatus}")
    public ResponseEntity <List<ClientRequests>> getClientRequestsByClientRequestStatus(@PathVariable(name = "clientRequestStatus") ClientRequestStatus clientRequestStatus) {
        List<ClientRequests> clientRequests = clientReguestsDatabaseService.getClientRequestsByClientRequestStatus(clientRequestStatus);
        return createResponseEntity(clientRequests);
    }

    @GetMapping(value = "/clientReguests/find/insuranseProgramId/{insuranceProgramId}")
    public ResponseEntity <List<ClientRequests>> getClientRequestsByInsuranceProgramId(@PathVariable(name = "insuranceProgramId") Integer insuranceProgramId) {
        List<ClientRequests> clientRequests = clientReguestsDatabaseService.getClientRequestsByInsuranceProgramId(insuranceProgramId);
        return createResponseEntity(clientRequests);
    }

    @GetMapping(value = "/clientReguests/find/brandId/{brandId}")
    public ResponseEntity <List<ClientRequests>> getClientRequestsByBrandId(@PathVariable(name = "brandId") Integer brandId) {
        List<ClientRequests> clientRequests = clientReguestsDatabaseService.getClientRequestsByBrandId(brandId);
        return createResponseEntity(clientRequests);
    }

    @GetMapping(value = "/clientReguests/find/clientId/{clientId}")
    public ResponseEntity <List<ClientRequests>> getClientRequestsByClientId(@PathVariable(name = "clientId") Integer clientId) {
        List<ClientRequests> clientRequests = clientReguestsDatabaseService.getClientRequestsByClientId(clientId);
        return createResponseEntity(clientRequests);
    }

    @GetMapping(value = "/clientRequests/find/id/{id}")
    public ResponseEntity <Optional<ClientRequests>> getClientRequestById(@PathVariable(name = "id") Integer id) {
        Optional<ClientRequests> clientRequest = clientReguestsDatabaseService.getClientRequestById(id);
        return ResponseEntity.ok(clientRequest);
    }

    @GetMapping(value = "/clientRequests/find/carCost/{id}")
    public ResponseEntity <Double> getCarCostClientRequests(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(clientReguestsDatabaseService.getCarCostClientRequests(id));
    }

    @GetMapping(value = "/clientRequests/find/all")
    public ResponseEntity <List<ClientRequests>> getAllClientRequests() {
        List<ClientRequests> clientRequests = clientReguestsDatabaseService.getAllClientRequests();
        return createResponseEntity(clientRequests);
    }

    @PostMapping(value = "/clientRequests/create")
    public ResponseEntity <ClientRequests> createNewCClientRequests(@RequestBody ClientRequests clientRequests) {
        clientReguestsDatabaseService.create(clientRequests);
        return ResponseEntity.ok(clientRequests);
    }

    @PutMapping(value = "/clientRequests/update")
    public ResponseEntity <ClientRequests> updateClientRequests(@RequestBody ClientRequests clientRequests) {
        clientReguestsDatabaseService.update(clientRequests);
        return ResponseEntity.ok(clientRequests);
    }

    private ResponseEntity<List<ClientRequests>> createResponseEntity(List<ClientRequests> clientRequests) {
        if (clientRequests != null && !clientRequests.isEmpty()) {
            return ResponseEntity.ok(clientRequests);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
