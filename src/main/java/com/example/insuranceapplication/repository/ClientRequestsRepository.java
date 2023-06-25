package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.ClientRequests;
import com.example.insuranceapplication.entity.enam.ClientRequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface ClientRequestsRepository extends JpaRepository<ClientRequests, Integer> {
    Collection<ClientRequests> getClientRequestsByClientRequestStatus(ClientRequestStatus clientRequestStatus);

    Collection<ClientRequests> getClientRequestsByBrandID(Integer brandId);

    Collection<ClientRequests> getClientRequestsByClientId(Integer clientId);

    Collection<ClientRequests> getClientRequestsByInsuranceProgramId(Integer insuranceProgramId);

    @Query(value = "SELECT " +
            "ClientRequests .carCost\n" +
            "FROM ClientRequests \n" +
            "where ClientRequests .id = :id")
    ClientRequests getCarCostClientRequests(@Param("id") Integer id);
}

