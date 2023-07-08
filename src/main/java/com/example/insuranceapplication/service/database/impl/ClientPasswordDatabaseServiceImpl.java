package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.ClientPassword;
import com.example.insuranceapplication.entity.enam.PasswordStatus;
import com.example.insuranceapplication.entity.updateDto.ClientPasswordUpdateDto;
import com.example.insuranceapplication.repository.ClientPasswordRepository;
import com.example.insuranceapplication.service.database.ClientPasswordDatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
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
        verificationPassword(clientPassword.getPassword());
        verificationLogin(clientPassword.getLogin());
        return clientPasswordRepository.save(clientPassword);
    }

    @Override
    public ClientPassword update(ClientPassword clientPassword) {
        return clientPasswordRepository.save(clientPassword);
    }

    @Override
    public void verificationPassword(String password) {
        {
            if (clientPasswordRepository.getClientPasswordByPassword(password) != null) {
                log.info("Такой пароль существует");
                throw new IllegalArgumentException();
            }
            log.info("Можно продолжать");
            for (int i = 0; i < password.length(); i++) {
                int length = password.length();
                if (length <= 8) {
                    log.info("Пароль не соответствует требованиям, поскольку в нем количество букв меньше 8");
                    throw new IllegalArgumentException();
                }
            }
            String bigLetter = password.toLowerCase();
            if (bigLetter.equals(password)) {
                log.info("Пароль не соответствует требованиям, поскольку в нем отсутствуют заглавные буквы");
                throw new IllegalArgumentException();
            }
            String lowercaseLetter = password.toUpperCase();
            if (lowercaseLetter.equals(password)) {
                log.info("Пароль не соответствует требованиям, поскольку в нем отсутствуют строчные буквы");
                throw new IllegalArgumentException();
            }
            for (int i = 0; i < password.length(); i++) {
                int num = Character.getNumericValue(password.charAt(i));
                if (num >= 10) {
                    log.info("Пароль не соответствует требованиям, поскольку в нем отсутствуют цифры");
                    throw new IllegalArgumentException();
                }
            }
            log.info("Пароль идеален");
        }
    }


    @Override
    public ClientPassword getClientPasswordByPassword(String password) {
        return clientPasswordRepository.getClientPasswordByPassword(password);
    }

    @Override
    public void verificationLogin(String login) {
        {
            if (clientPasswordRepository.getClientPasswordByLogin(login) != null) {
                log.info("Такой логин существует");
                throw new IllegalArgumentException();
            } else {
                log.info("Можно продолжать");

                for (int i = 0; i < login.length(); i++) {
                    int length = login.length();
                    if (length <= 6) {
                        log.info("Логин не соответствует требованиям, поскольку в нем количество букв меньше 6");
                        throw new IllegalArgumentException();
                    }
                }
                String bigLetter = login.toLowerCase();
                if (bigLetter.equals(login)) {
                    log.info("Логин не соответствует требованиям, поскольку в нем отсутствуют заглавные буквы");
                    throw new IllegalArgumentException();
                }
                String lowercaseLetter = login.toUpperCase();
                if (lowercaseLetter.equals(login)) {
                    log.info("Логин не соответствует требованиям, поскольку в нем отсутствуют строчные буквы");
                    throw new IllegalArgumentException();
                }
                for (int i = 0; i < login.length(); i++) {
                    int num = Character.getNumericValue(login.charAt(i));
                    if (num >= 10) {
                        log.info("Логин не соответствует требованиям, поскольку в нем отсутствуют цифры");
                        throw new IllegalArgumentException();
                    }
                }
                log.info("Логин идеален");
            }

        }

    }

    @Override
    public ClientPassword getClientPasswordByLogin(String login) {
        return clientPasswordRepository.getClientPasswordByLogin(login);
    }

    @Override
    public void delete(Integer id) {
        clientPasswordRepository.deleteById(id);
    }


    @Override
    public Optional<ClientPassword> updateWithCheck(Integer id, ClientPasswordUpdateDto clientPasswordUpdateDto) {
        Optional<ClientPassword> clientPasswordOptional = clientPasswordRepository.findById(id);
        if (clientPasswordOptional.isPresent() && clientPasswordUpdateDto != null) {
            ClientPassword clientPassword = clientPasswordOptional.get();
            if (clientPasswordUpdateDto.getLogin() != null) {
                clientPassword.setLogin(clientPasswordUpdateDto.getLogin());
            }
            if (clientPasswordUpdateDto.getPassword() != null) {
                clientPassword.setPassword(clientPasswordUpdateDto.getPassword());
            }
            if (clientPasswordUpdateDto.getPasswordStatus() != null) {
                clientPassword.setPasswordStatus(clientPasswordUpdateDto.getPasswordStatus());
            }
            clientPasswordRepository.save(clientPassword);
            return Optional.of(clientPassword);
        }
        return Optional.empty();
    }

}