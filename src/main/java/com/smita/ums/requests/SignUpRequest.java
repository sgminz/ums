package com.smita.ums.requests;

import lombok.Data;

@Data
public class SignUpRequest {

    private String name;
    private String emailId;
    private String password;
}
