package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.Client;
import com.example.insuranceapplication.entity.updateDto.ClientUpdateDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ClientDatabaseService {

    /**
     * Finds a Client entity from database by name and surname of the Client
     * @param name       The name of the Client
     * @param surname    The surname of the Client
     * @return  Client entity from database that was found by name and surname of the Client
     */
    Client getClientByName(String name, String surname);

    /**
     * Finds a Client entity from database by date of birthday of the Client
     * @param dateOfBirthday  The date of birthday of the Client
     * @return Client entity from database that was found by date of birthday of the Client
     */
    Client getClientByDateOfBirthday(LocalDate dateOfBirthday);

    /**
     * Finds a Client entity from database by specified Client id
     * @param id   The id of the Client
     * @return  Client entity from database that was found by by specified Client id
     */
    Optional<Client> getClientById(Integer id);

    /**
     * Finds all Сlient entity from database
     * @return All Client entity from database
     */
    List<Client> getAllClients();

    /**
     * Create new Client entity
     * @param client The new Client entity (Integer id,String surname,String name, LocalDate dateOfBirthday, String eMail, String phoneNumber,String address, Integer clientPasswordId, Timestamp createdAt)
     * @return  The new Client entity
     */
    Client create(Client client);

    /**
     * Deletion a Сlient entity from database by specified Client id
     * @param id  The id of the Client
     */
    void delete(Integer id);

    /**
     * Change one or more parameters in Client entity from database by specified Client id
     * @param id    The id of the Client
     * @param clientUpdateDto   The parameters, which need to be replaced (String surname, String name, LocalDate dateOfBirthday, String eMail, String phoneNumber, String address,Integer clientPasswordId)
     * @return   The Client entity with new parameters
     */
    Optional<Client> updateWithCheck(Integer id, ClientUpdateDto clientUpdateDto);
}
