package com.example.insuranceapplication.entity.updateDto;

import com.example.insuranceapplication.entity.enam.InsuranceEventInContractNumber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
@Setter
public class ContractNumberUpdateDto {
    public InsuranceEventInContractNumber insuranceEventInContractNumber;
    public Timestamp startedAt;
    public Timestamp finishedAt;
}
