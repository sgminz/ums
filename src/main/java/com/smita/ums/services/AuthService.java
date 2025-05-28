package com.smita.ums.services;

import com.smita.ums.entity.User;
import com.smita.ums.repository.UserRepository;
import com.smita.ums.requests.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public void signup(SignUpRequest signUpRequest){
        User user = userRepository.findByEmail(signUpRequest.getEmailId()).orElse(null);
        if(Objects.isNull(user)){
            user = User.builder().email(signUpRequest.getEmailId())
                    .name(signUpRequest.getName())
                    .password(signUpRequest.getPassword()).build();
            user = userRepository.save(user);
        }
    }
}
