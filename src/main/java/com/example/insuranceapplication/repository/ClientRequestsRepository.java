package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.ClientRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ClientRequestsRepository extends JpaRepository<ClientRequests, Integer> {
Collection<ClientRequests> getClientRequestsByIsConfirmed (boolean isConfirmed);

}
