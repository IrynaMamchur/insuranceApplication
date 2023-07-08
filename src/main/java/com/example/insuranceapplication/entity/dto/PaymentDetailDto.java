package com.example.insuranceapplication.entity.dto;

import com.example.insuranceapplication.entity.ContractNumber;
import com.example.insuranceapplication.entity.Payment;

public class PaymentDetailDto {
    public ContractNumber contractNumberId;
    public Payment paymentId;

    public PaymentDetailDto(ContractNumber contractNumberId, Payment paymentId) {
        this.contractNumberId = contractNumberId;
        this.paymentId = paymentId;
    }

    public ContractNumber getContractNumberId() {
        return contractNumberId;
    }

    public void setContractNumberId(ContractNumber contractNumberId) {
        this.contractNumberId = contractNumberId;
    }

    public Payment getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Payment paymentId) {
        this.paymentId = paymentId;
    }
}
