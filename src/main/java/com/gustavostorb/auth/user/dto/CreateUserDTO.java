package com.gustavostorb.auth.user.dto;

import com.gustavostorb.auth.user.enums.Roles;
import com.gustavostorb.auth.user.model.User;
import com.gustavostorb.auth.user.service.TokenService;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ToString()
@Data
public class CreateUserDTO {

    @NotNull(message = "É necessário informar um usuário")
    @Size(min = 4, max = 255, message = "Tamanho mínimo de usuario: 4 caracteres")
    private String username;

    @Email
    @NotNull(message = "É necessário informar um email")
    @Size(min = 4, max = 255, message = "Tamanho mínimo de email: 4 caracteres")
    private String email;

    @NotNull(message = "É necessário informar uma senha")
    @Size(min = 8, max = 255, message = "Tamanho mínimo de senha: 8 caracteres")
    private String password;

    public User toUser() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String token = TokenService.generate();

        return new User(
                this.username,
                this.email,
                passwordEncoder.encode(password),
                Roles.USER,
                token
        );
    }
}
