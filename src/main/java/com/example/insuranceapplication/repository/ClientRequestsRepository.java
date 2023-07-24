package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.ClientRequests;
import com.example.insuranceapplication.entity.enam.ClientRequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ClientRequestsRepository extends JpaRepository<ClientRequests, Integer> {
    Collection<ClientRequests> getClientRequestsByClientRequestStatus(ClientRequestStatus clientRequestStatus);

    Collection<ClientRequests> getClientRequestsByClientId(Integer clientId);

}

