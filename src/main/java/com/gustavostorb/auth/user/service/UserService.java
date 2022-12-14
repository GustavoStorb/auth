package com.gustavostorb.auth.user.service;

import com.gustavostorb.auth.user.dto.CreateUserDTO;
import com.gustavostorb.auth.user.dto.UpdateUserDTO;
import com.gustavostorb.auth.user.enums.Roles;
import com.gustavostorb.auth.user.model.User;
import com.gustavostorb.auth.user.repository.UserRepository;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    public List<User> findAll(String token) {
        User authorizedUser = this.tokenService.getUserByTokenAndValidate(token);
        if(authorizedUser == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuário não autorizado");
        }

        List<User> users = authorizedUser.getRole() == Roles.ADMIN ?
                        this.userRepository.findAll() :
                        List.of(new User[]{authorizedUser});

        users.forEach(user -> user.setPassword(null));
        users.forEach(user -> user.setToken(null));
        return users;
    }

    public User findById(Long id, String token) {
        User authorizedUser = this.tokenService.getUserByTokenAndValidate(token);
        if(authorizedUser == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token inválido!");
        }

        if(authorizedUser.getRole() == Roles.USER && !authorizedUser.getId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Você não tem permissão para acessar este usuário!");
        }

        Optional<User> user = this.userRepository.findById(id);

        if(user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Este usuário não existe!");
        }

        User userFound = user.get();
        userFound.setPassword(null);
        return userFound;
    }

    public User store(CreateUserDTO createUserDTO) {
        if(createUserDTO == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Corpo da requisição inválido!");
        }

        if(this.userRepository.findByUsername(createUserDTO.getUsername()) != null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Este usuário já existe!");
        }

        if(this.userRepository.findByEmail(createUserDTO.getEmail()) != null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Este email já está sendo usado!");
        }

        User user =  this.userRepository.save(createUserDTO.toUser());
        user.setPassword(null);
        return user;
    }
    public User update(String token, Long id, UpdateUserDTO updateUserDTO) {
        User authorizedUser = this.tokenService.getUserByTokenAndValidate(token);
        if(authorizedUser == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token inválido!");
        }

        if(authorizedUser.getRole() == Roles.USER && !authorizedUser.getId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Você não tem permissão para acessar este usuário!");
        }

        if(updateUserDTO == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Corpo da requisição inválido!");
        }

        User user = this.userRepository.findById(id).orElse(null);
        if(user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Este usuário não existe!");
        }

        updateUserDTO.updateUser(user);
        this.userRepository.save(user);

        user.setPassword(null);
        return user;
    }
    public void delete(String token, Long id){
        User authorizedUser = this.tokenService.getUserByTokenAndValidate(token);
        if(authorizedUser == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token inválido!");
        }

        if(authorizedUser.getRole() == Roles.USER && !authorizedUser.getId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Você não tem permissão para acessar este usuário!");
        }

        Optional<User> user = this.userRepository.findById(id);
        if(user.isPresent()) {
            userRepository.deleteById(id);
        }
    }

}
