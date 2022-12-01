package com.gustavostorb.auth.user.service;

import com.gustavostorb.auth.user.model.User;
import com.gustavostorb.auth.user.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TokenService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByToken(String token) {
        if(token == null) return null;
        return this.userRepository.findByToken(token);
    }

    public static String generate() {
        return RandomStringUtils.randomAlphabetic(69);
    }

}
