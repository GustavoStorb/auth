package com.gustavostorb.auth.user.dto;

import com.gustavostorb.auth.user.model.User;
import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ToString()
@Data
public class UpdateUserDTO {

    @Size(min = 4, max=255, message = "Tamanho mínimo de usuario: 4 caracteres")
    private String username;

    @Email(message = "Invalid email")
    @Size(min = 4, max=255, message = "Tamanho mínimo de email: 4 caracteres")
    private String email;

    @Size(min = 8, max=255, message = "Tamanho mínimo da nova senha: 8 caracteres")
    private String password;

    @Size(min = 8, max=255, message = "Tamanho mínimo da confirmação de senha: 8 caracteres")
    private String confirmPassword;

    @NotNull(message = "É necessário informar uma senha")
    @Size(min = 8, max=255, message = "Tamanho mínimo de senha: 8 caracteres")
    private String actualPassword;

    public void updateUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if(!encoder.matches(this.actualPassword, user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha atual incorreta");
        }

        if(this.username != null) {
            user.setUsername(this.username);
        }

        if(this.email != null) {
            user.setEmail(this.email);
        }

        if(this.password != null && this.confirmPassword != null) {
            if(!this.password.equals(this.confirmPassword)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senhas não conferem");
            }

            user.setPassword(encoder.encode(this.password));
        }

    }
}