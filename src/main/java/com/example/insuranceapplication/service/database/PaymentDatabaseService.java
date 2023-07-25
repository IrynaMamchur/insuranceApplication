package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.payment.Payment;
import com.example.insuranceapplication.entity.updateDto.PaymentUpdateDto;

import java.util.List;
import java.util.Optional;

public interface PaymentDatabaseService {

    /**
     * Finds an Payment entity from database by amount of insurance payment
     * @param amount The amount of the Payment
     * @return Payment entity from database that was found by amount of insurance payment
     */
    List<Payment> getPaymentsByAmount(Double amount);
    /**
     * Finds all Payment entity from database
     * @return All Payment entity from database
     */
    List<Payment> getAllPayments();

    /**
     * Finds an Payment entity from database by specified Payment id
     * @param id The id of the Payment.
     * @return Payment entity from database that was found by the specified id of the Payment
     */
    Optional<Payment> getPaymentById(Integer id);

    /**
     * Create new Payment entity
     * @param payment  The new Payment entity(Integer id, LocalDate dateOfPayment, Double amount, Timestamp createdAt)
     * @return  The new Payment entity
     */
    Payment create(Payment payment);

    /**
     * Deletion an Payment entity from database by specified Payment id
     * @param id  The id of the Payment
     */
    void delete(Integer id);

    /**
     * Change one or more parameters in Payment entity from database by specified Payment id
     * @param id  The id of the Payment
     * @param paymentUpdateDto   The parameters, which need to be replaced(LocalDate dateOfPayment, Double amount)
     * @return  The Payment entity with new parameters
     */

    Optional<Payment> updateWithCheck(Integer id, PaymentUpdateDto paymentUpdateDto);

}
