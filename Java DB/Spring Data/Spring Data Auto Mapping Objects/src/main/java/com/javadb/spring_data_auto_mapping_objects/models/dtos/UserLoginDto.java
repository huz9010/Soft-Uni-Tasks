package com.javadb.spring_data_auto_mapping_objects.models.dtos;

import jakarta.validation.constraints.Email;

import static com.javadb.spring_data_auto_mapping_objects.constants.ErrorMessages.INVALID_EMAIL;

public class UserLoginDto {

    private String email;
    private String password;

    public UserLoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserLoginDto() {
    }

    @Email(message = INVALID_EMAIL)
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
