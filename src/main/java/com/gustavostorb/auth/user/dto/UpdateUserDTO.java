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

    @Size(min = 4, message = "Minimum username length: 4 characters")
    private String username;

    @Email(message = "Invalid email")
    private String email;

    @Size(min = 8, message = "Minimum password length: 8 characters")
    private String password;

    @Size(min = 8, message = "Minimum confirmPassword length: 8 characters")
    private String confirmPassword;

    @NotNull(message = "Confirm actualPassword is required")
    @Size(min = 8, message = "Minimum actualPassword length: 8 characters")
    private String actualPassword;

    public void updateUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if(!encoder.matches(this.actualPassword, user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Actual Password doesn't match");
        }

        if(this.username != null) {
            user.setUsername(this.username);
        }

        if(this.email != null) {
            user.setEmail(this.email);
        }

        if(this.password != null && this.confirmPassword != null) {
            if(!this.password.equals(this.confirmPassword)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password doesn't match with confirmPassword");
            }

            user.setPassword(encoder.encode(this.password));
        }

    }
}