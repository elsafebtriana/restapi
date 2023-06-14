package com.test.restapi.controller;

import com.test.restapi.entity.User;
import com.test.restapi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user")
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> findListUser(){
        return userService.findListUsers();
    }

    @GetMapping(value = "/{id:[\\d]+}")
    @PreAuthorize("hasRole('ADMIN')")
    public User findUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }
}
