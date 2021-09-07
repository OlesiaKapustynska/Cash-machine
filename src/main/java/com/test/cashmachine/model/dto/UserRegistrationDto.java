package com.test.cashmachine.model.dto;

import lombok.Data;
import lombok.NonNull;

@Data
@NonNull
public class UserRegistrationDto {
    private String firstName;
    private String lastName;
    private Long cardsNumber;
    private String password;
    private String repeatPassword;
}
