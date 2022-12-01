package com.gustavostorb.auth.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gustavostorb.auth.user.enums.Roles;
import lombok.*;

import javax.persistence.*;

@Entity(name = "users")
@Getter @Setter
@Data @RequiredArgsConstructor
public class User {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="username", unique = true)
    @JsonIgnore
    private String username;
    @Column(name="email", unique = true)
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="role")
    private Roles role;
    @Column(name="token", unique = true)
    private String token;



    public User(String username, String email, String password, Roles role, String token) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.token = token;
    }

}
