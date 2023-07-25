package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.ClientRequests;
import com.example.insuranceapplication.entity.enam.ClientRequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ClientRequestsRepository extends JpaRepository<ClientRequests, Integer> {

    /**
     * Finds an СlientRequests entity from database by status ClientRequests
     * @param clientRequestStatus The status of the ClientRequests
     * @return  ClientRequests entity from database that was found by the status of the ClientRequests
     */
    Collection<ClientRequests> getClientRequestsByClientRequestStatus(ClientRequestStatus clientRequestStatus);

    /**
     * Finds an СlientRequests entity from database by specified Сlient id
     * @param clientId    The id of the Сlient
     * @return  СlientRequests entity from database that was found by the specified id of the Сlient
     */
    Collection<ClientRequests> getClientRequestsByClientId(Integer clientId);

}

