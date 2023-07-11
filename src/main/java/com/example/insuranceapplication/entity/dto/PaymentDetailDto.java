package com.example.insuranceapplication.entity.dto;

        import com.example.insuranceapplication.entity.ContractNumber;
        import com.example.insuranceapplication.entity.payment.Payment;
        import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PaymentDetailDto {

    public ContractNumber contractNumberId;

    public Payment paymentId;

}
