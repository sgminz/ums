package com.smita.ums.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SignUpRequest {

    @NotBlank(message = "Name cannot be null")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Not a valid email id")
    private String emailId;
    @NotNull(message = "Password cannot be empty")
    private String password;
}
