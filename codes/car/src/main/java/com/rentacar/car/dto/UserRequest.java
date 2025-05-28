package com.rentacar.car.dto;

import jakarta.validation.constraints.NotNull;

public class UserRequest{
    @NotNull(message = "Email cannot be null")
    @ValidEmail
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
