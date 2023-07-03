package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.ClientRequests;
import com.example.insuranceapplication.entity.enam.ClientRequestStatus;
import com.example.insuranceapplication.repository.ClientRequestsRepository;
import com.example.insuranceapplication.service.database.ClientReguestsDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientReguestsDatabaseServiceImpl implements ClientReguestsDatabaseService {
    private final ClientRequestsRepository clientRequestsRepository;


    @Override
    public List<ClientRequests> getClientRequestsByClientRequestStatus(ClientRequestStatus clientRequestStatus) {
        return (List<ClientRequests>) clientRequestsRepository.getClientRequestsByClientRequestStatus(clientRequestStatus);
    }

    @Override
    public List<ClientRequests> getClientRequestsByInsuranceProgramId(Integer insuranceProgramId) {
        return (List<ClientRequests>) clientRequestsRepository.getClientRequestsByInsuranceProgramId(insuranceProgramId);
    }

    @Override
    public List<ClientRequests> getClientRequestsByBrandID(Integer brandId) {
        return (List<ClientRequests>) clientRequestsRepository.getClientRequestsByBrandID(brandId);
    }

    @Override
    public List<ClientRequests> getClientRequestsByClientId(Integer clientId) {
        return (List<ClientRequests>) clientRequestsRepository.getClientRequestsByClientId(clientId);
    }

    @Override
    public Optional<ClientRequests> getClientRequestById(Integer id) {
        return clientRequestsRepository.findById(id);
    }

    @Override
    public List<ClientRequests> getAllClientRequests() {
        return clientRequestsRepository.findAll();
    }

    @Override
    public ClientRequests create(ClientRequests clientRequests) {
        return clientRequestsRepository.save(new ClientRequests());
    }

    @Override
    public double getCarCostClientRequests(Integer id) {
        return clientRequestsRepository.getCarCostClientRequests(id);
    }

//    @Override
//    public ClientRequests createCoefficient(Integer id) {
//        return clientRequestsRepository.createNewCoefficient(id);
//    }

    @Override
    public ClientRequests update(ClientRequests clientRequests) {
        return clientRequestsRepository.save(clientRequests);
    }

}
