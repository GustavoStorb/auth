package com.gustavostorb.auth.user.dto;

import com.gustavostorb.auth.user.enums.Roles;
import com.gustavostorb.auth.user.model.User;
import com.gustavostorb.auth.user.service.TokenService;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@ToString()
@Data
public class CreateUserDTO {

    @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
    private String user;

    @Email
    private String email;

    @Size(min = 8, message = "Minimum password length: 8 characters")
    private String password;

    public User toUser() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String token = TokenService.generate();

        return new User(
                this.user,
                this.email,
                passwordEncoder.encode(password),
                Roles.USER,
                token
        );
    }
}
