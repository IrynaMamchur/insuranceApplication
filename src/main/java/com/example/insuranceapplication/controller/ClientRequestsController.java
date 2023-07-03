package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.entity.ClientRequests;
import com.example.insuranceapplication.entity.enam.ClientRequestStatus;
import com.example.insuranceapplication.service.database.ClientReguestsDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ClientRequestsController {

    private final ClientReguestsDatabaseService clientReguestsDatabaseService;

    @GetMapping(value = "/clientReguests/find/status/{clientRequestStatus}")
    public List<ClientRequests> getClientRequestsByClientRequestStatus(@PathVariable(name = "clientRequestStatus") ClientRequestStatus clientRequestStatus) {
        List<ClientRequests> clientRequests = clientReguestsDatabaseService.getClientRequestsByClientRequestStatus(clientRequestStatus);
        return clientRequests;
    }

    @GetMapping(value = "/clientReguests/find/insuranse_program_id/{insuranceProgramId}")
    public List<ClientRequests> getClientRequestsByInsuranceProgramId(@PathVariable(name = "insuranceProgramId") Integer insuranceProgramId) {
        List<ClientRequests> clientRequests = clientReguestsDatabaseService.getClientRequestsByInsuranceProgramId(insuranceProgramId);
        return clientRequests;
    }

    @GetMapping(value = "/clientReguests/find/brand_id/{brandId}")
    public List<ClientRequests> getClientRequestsByBrandID(@PathVariable(name = "brandId") Integer brandId) {
        List<ClientRequests> clientRequests = clientReguestsDatabaseService.getClientRequestsByBrandID(brandId);
        return clientRequests;
    }

    @GetMapping(value = "/clientReguests/find/client_id/{clientId}")
    public List<ClientRequests> getClientRequestsByClientId(@PathVariable(name = "clientId") Integer clientId) {
        List<ClientRequests> clientRequests = clientReguestsDatabaseService.getClientRequestsByClientId(clientId);
        return clientRequests;
    }

    @GetMapping(value = "/clientRequests/find/id/{id}")
    public Optional<ClientRequests> getClientRequestById(@PathVariable(name = "id") Integer id) {
        Optional<ClientRequests> clientRequest = clientReguestsDatabaseService.getClientRequestById(id);
        return clientRequest;
    }

    @GetMapping(value = "/clientRequests/find/car_cost/{id}")
    public double getCarCostClientRequests(@PathVariable(name = "id") Integer id) {
        return clientReguestsDatabaseService.getCarCostClientRequests(id);
    }

    @GetMapping(value = "/clientRequests/find/all")
    public List<ClientRequests> getAllClientRequests() {
        List<ClientRequests> clientRequests = clientReguestsDatabaseService.getAllClientRequests();
        return clientRequests;
    }

    @PostMapping(value = "/clientRequests/create")
    public ClientRequests createNewCClientRequests(@RequestBody ClientRequests clientRequests) {
        clientReguestsDatabaseService.create(clientRequests);
        return clientRequests;
    }

    @PutMapping(value = "/clientRequests/update")
    public ClientRequests updateClientRequests(@RequestBody ClientRequests clientRequests) {
        clientReguestsDatabaseService.update(clientRequests);
        return clientRequests;
    }

//    @GetMapping(value = "/clientRequests/create/coefficient/{id}")
//    public ClientRequests createCoefficient(@PathVariable(name = "id") Integer id) {
//        ClientRequests clientRequests = clientReguestsDatabaseService.createCoefficient(id);
//        return clientRequests;
//    }

}
