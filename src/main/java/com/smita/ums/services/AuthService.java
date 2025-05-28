package com.smita.ums.services;

import com.smita.ums.entity.User;
import com.smita.ums.repository.UserRepository;
import com.smita.ums.requests.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void signup(SignUpRequest signUpRequest){
        User user = userRepository.findByEmail(signUpRequest.getEmailId()).orElse(null);
        if(Objects.isNull(user)){
            String secret = UUID.randomUUID().toString();
            user = User.builder().email(signUpRequest.getEmailId())
                    .name(signUpRequest.getName())
                    .secret(secret)
                    .password(bCryptPasswordEncoder.encode(signUpRequest.getPassword())).build();
            user = userRepository.save(user);
        }


    }
}
