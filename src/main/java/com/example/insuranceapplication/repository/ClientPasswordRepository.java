package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.entity.ClientPassword;
import com.example.insuranceapplication.entity.enam.PasswordStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ClientPasswordRepository extends JpaRepository<ClientPassword, Integer> {

    /**
     * Finds an СlientPassword entity from database by login and password
     * @param login  The login of the ClientPassword.
     * @param password The password of the ClientPassword
     * @return ClientPassword entity from database that was found by login and password of the ClientPassword
     */
    ClientPassword getClientPasswordByLoginAndPassword(String login, String password);

    /**
     * Finds all ClientPassword entity from database by password status of the ClientPassword
     * @param passwordStatus The password status of the ClientPassword
     * @return All ClientPassword entity from database by password status of the ClientPassword
     */
    Collection<ClientPassword> getClientPasswordsByPasswordStatus(PasswordStatus passwordStatus);

    /**
     * Finds an СlientPassword entity from database by login of the ClientPassword
     * @param login The login of the ClientPassword
     * @return  The СlientPassword entity from database by login of the ClientPassword
     */
    ClientPassword getClientPasswordByLogin(String login);

    /**
     * Finds an СlientPassword entity from database by password of the ClientPassword
     * @param password  The password of the ClientPassword
     * @return  The СlientPassword entity from database by password of the ClientPassword
     */
    ClientPassword getClientPasswordByPassword(String password);

}
