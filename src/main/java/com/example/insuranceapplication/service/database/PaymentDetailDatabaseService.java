package com.example.insuranceapplication.service.database;

import com.example.insuranceapplication.entity.payment.PaymentDetail;
import com.example.insuranceapplication.entity.updateDto.PaymentDetailUpdateDto;

import java.util.List;
import java.util.Optional;

public interface PaymentDetailDatabaseService {


    /**
     * Finds all PaymentDetail entity from database
     * @return All PaymentDetail entity from database
     */
    List<PaymentDetail> getAllPaymentDetails();

    /**
     * Finds an PaymentDetail entity from database by specified PaymentDetail id
     * @param id The id of the PaymentDetail.
     * @return PaymentDetail entity from database that was found by the specified id of the PaymentDetail
     */
    Optional<PaymentDetail> getPaymentDetailById(Integer id);

    /**
     * Create new PaymentDetail entity
     * @param paymentDetail  The new PaymentDetail entity(Integer paymentId, LocalDate datePaymentPlan, Double amountPlan, Timestamp createdAt, Integer number)
     * @return  The new PaymentDetail entity
     */
    PaymentDetail create(PaymentDetail paymentDetail);

    /**
     * Deletion an PaymentDetail entity from database by specified PaymentDetail id
     * @param id  The id of the PaymentDetail
     */
    void delete(Integer id);

    /**
     * Change one or more parameters in PaymentDetail entity from database by specified PaymentDetail id
     * @param id  The id of the PaymentDetail
     * @param paymentDetailUpdateDto   The parameters, which need to be replaced(Integer paymentId, LocalDate datePaymentPlan, Double amountPlan, Timestamp createdAt, Integer number, Integer contractNumberId)
     * @return  The PaymentDetail entity with new parameters
     */
    Optional<PaymentDetail> updateWithCheck(Integer id, PaymentDetailUpdateDto paymentDetailUpdateDto);
}
