package com.gustavostorb.auth.user.service;

import com.gustavostorb.auth.user.model.User;
import com.gustavostorb.auth.user.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class TokenService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByTokenAndValidate(String token) {
        if(token == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token de autorização inválido!");
        }

        User user = this.userRepository.findByToken(token);
        if(user == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token de autorização inválido!");
        }

        return user;
    }

    public static String generate() {
        return RandomStringUtils.randomAlphabetic(69);
    }

}
