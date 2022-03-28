package com.example.fm6app.controller;

import com.example.fm6app.domain.User;
import com.example.fm6app.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    public List<User> getUsers() {
        return userService.getUsers();
    }
    @GetMapping("/emails/")
    public User findUserByEmail(String email) {
        return userService.findUserByEmail(email);
    }
    @GetMapping("/usernames/")
    public User findUserByUsername(String username) {
        return userService.findUserByUsername(username);
    }
}
