package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.ClientPassword;
import com.example.insuranceapplication.entity.enam.PasswordStatus;
import com.example.insuranceapplication.entity.updateDto.ClientPasswordUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ClientPasswordDatabaseService {

    /**
     * Finds an СlientPassword entity from database by login and password
     * @param login  The login of the ClientPassword.
     * @param password The password of the ClientPassword
     * @return ClientPassword entity from database that was found by login and password of the ClientPassword
     */
    ClientPassword getClientPassword(String login, String password);

    /**
     * Finds all ClientPassword entity from database by password status of the ClientPassword
     * @param passwordStatus The password status of the ClientPassword
     * @return All ClientPassword entity from database by password status of the ClientPassword
     */
    List<ClientPassword> getAllClientPasswordsByPasswordStatus(PasswordStatus passwordStatus);

    /**
     * Finds an СlientPassword entity from database by specified ClientPassword id
     * @param id   The id of the ClientPassword
     * @return  ClientPassword entity from database that was found by the specified id of the ClientPassword
     */
    Optional<ClientPassword> getClientPasswordById(Integer id);

    /**
     * Finds all СlientPassword entity from database
     * @return  All ClientPassword entity from database
     */
    List<ClientPassword> getAllClientPassword();

    /**
     * Create new ClientPassword entity
     * @param clientPassword  The new ClientPassword entity (Integer id,String login,String password,Timestamp createdAt, PasswordStatus passwordStatus)
     * @return   The new ClientPassword entity
     */
    ClientPassword create(ClientPassword clientPassword);

    /**
     *Checking the password for compliance with the stated requirements
     * @param password   The password of the ClientPassword
     */
    void verificationPassword(String password);


    /**
     * Finds an СlientPassword entity from database by password of the ClientPassword
     * @param password  The password of the ClientPassword
     * @return  The СlientPassword entity from database by password of the ClientPassword
     */
    ClientPassword getClientPasswordByPassword(String password);

    /**
     * Checking the login for compliance with the stated requirements
     * @param login The login of the ClientPassword
     */
    void verificationLogin(String login);

    /**
     * Finds an СlientPassword entity from database by login of the ClientPassword
     * @param login The login of the ClientPassword
     * @return  The СlientPassword entity from database by login of the ClientPassword
     */

    ClientPassword getClientPasswordByLogin(String login);

    /**
     * Deletion an СlientPassword entity from database by specified ClientPassword id
     * @param id The id of the ClientPassword
     */
    void delete(Integer id);

    /**
     * Change one or more parameters in ClientPassword entity from database by specified ClientPassword id
     * @param id  The id of the ClientPassword
     * @param clientPasswordUpdateDto   The parameters, which need to be replaced (String login,String password, String passwordStatus)
     * @return   The ClientPassword entity with new parameters
     */
    Optional<ClientPassword> updateWithCheck(Integer id, ClientPasswordUpdateDto clientPasswordUpdateDto);

}




