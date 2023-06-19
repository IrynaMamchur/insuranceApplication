package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.ClientPassword;
import com.example.insuranceapplication.entity.enam.PasswordStatus;
import com.example.insuranceapplication.repository.ClientPasswordRepository;
import com.example.insuranceapplication.service.database.ClientPasswordDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientPasswordDatabaseServiceImpl implements ClientPasswordDatabaseService {
    private final ClientPasswordRepository clientPasswordRepository;

    @Override
    public ClientPassword getClientPassword(String login, String password) {
        return clientPasswordRepository.getClientPasswordByLoginAndPassword(login, password);
    }

    @Override
    public List<ClientPassword> getAllClientPasswordsByPasswordStatus(PasswordStatus passwordStatus) {
        return (List<ClientPassword>) clientPasswordRepository.getClientPasswordsByPasswordStatus(passwordStatus);
    }

    @Override
    public Optional<ClientPassword> getClientPasswordById(Integer id) {
        return clientPasswordRepository.findById(id);
    }

    @Override
    public List<ClientPassword> getAllClientPassword() {
        return clientPasswordRepository.findAll();
    }

    @Override
    public ClientPassword create(ClientPassword clientPassword) {
        return clientPasswordRepository.save(new ClientPassword());
    }

    @Override
    public ClientPassword update(ClientPassword clientPassword) {
        return clientPasswordRepository.save(clientPassword);
    }
}
