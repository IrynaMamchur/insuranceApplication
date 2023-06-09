package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.ClientRequests;
import com.example.insuranceapplication.entity.enam.ClientRequestStatus;
import com.example.insuranceapplication.entity.updateDto.ClientRequestUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ClientReguestsDatabaseService {

    List<ClientRequests> getClientRequestsByClientRequestStatus(ClientRequestStatus clientRequestStatus);

    List<ClientRequests> getClientRequestsByClientId(Integer clientId);

    Optional<ClientRequests> getClientRequestById(Integer id);

    List<ClientRequests> getAllClientRequests();

    ClientRequests update(ClientRequests clientRequests);

    ClientRequests create(ClientRequests clientRequests);

    double getCarCostClientRequests(Integer id);

    void delete(Integer id);

    Optional<ClientRequests> updateWithCheck(Integer id, ClientRequestUpdateDto clientRequestUpdateDto);

}
