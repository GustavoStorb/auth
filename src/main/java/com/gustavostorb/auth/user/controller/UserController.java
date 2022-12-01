package com.gustavostorb.auth.user.controller;

import com.gustavostorb.auth.user.dto.CreateUserDTO;
import com.gustavostorb.auth.user.dto.UpdateUserDTO;
import com.gustavostorb.auth.user.model.User;
import com.gustavostorb.auth.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> findAll(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(this.userService.findAll(token));
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        return ResponseEntity.ok(this.userService.findById(id, token));
    }

    @PostMapping()
    public ResponseEntity<User> store(@Valid @RequestBody CreateUserDTO createUserDTO) {
        return new ResponseEntity<>(this.userService.store(createUserDTO), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> update(@RequestHeader("Authorization") String token, @PathVariable Long id, @Valid @RequestBody UpdateUserDTO updateUserDTO){
        return new ResponseEntity<>(this.userService.update(token, id, updateUserDTO), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<User> delete(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        userService.delete(token, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}