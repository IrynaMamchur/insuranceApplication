package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.ClientRequests;
import com.example.insuranceapplication.entity.enam.ClientRequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ClientRequestsRepository extends JpaRepository<ClientRequests, Integer> {
    Collection<ClientRequests> getClientRequestsByClientRequestStatus(ClientRequestStatus clientRequestStatus);

    Collection<ClientRequests> getClientRequestsByBrandID(Integer brandId);

    Collection<ClientRequests> getClientRequestsByClientId(Integer clientId);

    Collection<ClientRequests> getClientRequestsByInsuranceProgramId(Integer insuranceProgramId);

    @Query(value = "SELECT " +
            "CarBrand.coefficient* CarEngineCapacity.coefficient * CarInsuranceProgram.coefficient" +
            " * CarYearOfIssue.coefficient AS coefficient " +
            "FROM ClientRequests\n" +
            "JOIN CarBrand ON ClientRequests.brandId= CarBrand.id \n" +
            "JOIN CarEngineCapacity ON ClientRequests.engineCapacityId = CarEngineCapacity.id\n" +
            "JOIN CarInsuranceProgram ON ClientRequests.insuranceProgramId =CarInsuranceProgram.id\n" +
            "JOIN CarYearOfIssue ON ClientRequests.careFirstRegistrId = CarYearOfIssue.id\n" +
            " where ClientRequests.id = :id ")
    ClientRequests createNewCoefficient(@Param("id") Integer id);


}
