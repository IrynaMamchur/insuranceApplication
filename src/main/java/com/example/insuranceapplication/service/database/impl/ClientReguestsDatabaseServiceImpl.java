package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.ClientRequests;
import com.example.insuranceapplication.entity.enam.ClientRequestStatus;
import com.example.insuranceapplication.entity.updateDto.ClientRequestUpdateDto;
import com.example.insuranceapplication.repository.ClientRequestsRepository;
import com.example.insuranceapplication.service.database.ClientReguestsDatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientReguestsDatabaseServiceImpl implements ClientReguestsDatabaseService {
    private final ClientRequestsRepository clientRequestsRepository;

    @Override
    public List<ClientRequests> getClientRequestsByClientRequestStatus(ClientRequestStatus clientRequestStatus) {
        return (List<ClientRequests>) clientRequestsRepository.getClientRequestsByClientRequestStatus(clientRequestStatus);
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
        return clientRequestsRepository.save(clientRequests);
    }


    @Override
    public void delete(Integer id) {
        clientRequestsRepository.deleteById(id);
    }


    @Override
    public Optional<ClientRequests> updateWithCheck(Integer id, ClientRequestUpdateDto clientRequestUpdateDto) {
        Optional<ClientRequests> clientRequestsOptional = clientRequestsRepository.findById(id);
        if (clientRequestsOptional.isPresent() && clientRequestUpdateDto != null) {
            ClientRequests clientRequests = clientRequestsOptional.get();
            if (clientRequestUpdateDto.getClientRequestStatus() != null) {
                clientRequests.setClientRequestStatus(ClientRequestStatus.valueOf(clientRequestUpdateDto.getClientRequestStatus()));
            }
//
            if (clientRequestUpdateDto.getInsurancePaymentId() != null) {
                clientRequests.setInsurancePaymentId(clientRequestUpdateDto.getInsurancePaymentId());
            }

            clientRequestsRepository.save(clientRequests);
            return Optional.of(clientRequests);
        }
        return Optional.empty();
    }

}
