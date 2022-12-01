package com.gustavostorb.auth.user.repository;

import com.gustavostorb.auth.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByToken(String token);
    User findByUsername(String username);
    User findByEmail(String email);

}
