package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.ClientRequests;
import com.example.insuranceapplication.entity.enam.ClientRequestStatus;
import com.example.insuranceapplication.entity.updateDto.ClientRequestUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ClientReguestsDatabaseService {
    /**
     * Finds an СlientRequests entity from database by status ClientRequests
     * @param clientRequestStatus The status of the ClientRequests
     * @return  ClientRequests entity from database that was found by the status of the ClientRequests
     */
    List<ClientRequests> getClientRequestsByClientRequestStatus(ClientRequestStatus clientRequestStatus);

    /**
     * Finds an СlientRequests entity from database by specified Сlient id
     * @param clientId    The id of the Сlient
     * @return  СlientRequests entity from database that was found by the specified id of the Сlient
     */
    List<ClientRequests> getClientRequestsByClientId(Integer clientId);

    /**
     * Finds an СlientRequests entity from database by specified СlientRequests id
     * @param id  The id of the СlientRequests
     * @return   СlientRequests entity from database that was found by the specified id of the СlientRequests
     */
    Optional<ClientRequests> getClientRequestById(Integer id);

    /**
     * Finds all СlientRequests entity from database
     * @return  All СlientRequests entity from database
     */
    List<ClientRequests> getAllClientRequests();

    /**
     * Create new СlientRequests entity
     * @param clientRequests   new СlientRequests entity(Integer id, Integer clientId, ClientRequestStatus clientRequestStatus, Timestamp createdAt, Integer insurancePaymentId)
     * @return   The new СlientRequests entity
     */
    ClientRequests create(ClientRequests clientRequests);

    /**
     * Deletion an СlientRequests entity from database by specified СlientRequests id
     * @param id  The id of the СlientRequests
     */
    void delete(Integer id);

    /**
     * Change one or more parameters in СlientRequests entity from database by specified СlientRequests id
     * @param id   The id of the СlientRequests
     * @param clientRequestUpdateDto  The parameters, which need to be replaced (String clientRequestStatus,Integer insurancePaymentId)
     * @return
     */
    Optional<ClientRequests> updateWithCheck(Integer id, ClientRequestUpdateDto clientRequestUpdateDto);

}
