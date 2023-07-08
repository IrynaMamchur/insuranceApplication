package com.example.insuranceapplication.entity.updateDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class ClientUpdateDto {
    public String surname;
    public String name;
    public LocalDate dateOfBirthday;
    public String eMail;
    public String phoneNumber;
    public String address;

}
