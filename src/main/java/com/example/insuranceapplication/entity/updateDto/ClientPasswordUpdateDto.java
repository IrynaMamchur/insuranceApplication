package com.example.insuranceapplication.entity.updateDto;

import com.example.insuranceapplication.entity.enam.PasswordStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ClientPasswordUpdateDto {
    public String login;
    public String password;
    public String passwordStatus;
}
