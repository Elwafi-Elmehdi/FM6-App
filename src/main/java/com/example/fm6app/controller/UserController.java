package com.example.fm6app.controller;

import com.example.fm6app.common.BodyView;
import com.example.fm6app.domain.User;
//import com.example.fm6app.exception.ExceptionHandling;
import com.example.fm6app.exception.UsernameExistsException;
import com.example.fm6app.service.facade.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @JsonView(BodyView.BasicUser.class)
    @GetMapping("/")
    public List<User> getUsers() {
        return userService.getUsers();
    }

//    @JsonView(BodyView.BasicUser.class)
//    @GetMapping("/emails/{email}")
//    public User findUserByEmail(@PathVariable String email) {
//        return userService.findUserByEmail(email);
//    }

//    @GetMapping("/usernames/{username}")
//    public User findUserByUsername(@PathVariable String username) {
//        return userService.findUserByUsername(username);
//    }

    @JsonView(BodyView.BasicUser.class)
    @PostMapping("/register")
    public User addUser(@RequestBody User user) throws UsernameExistsException {
        return userService.addUser(user);
    }
//    @JsonView(BodyView.BasicUser.class)
//    @PostMapping("/login")
//    public ResponseEntity<User> login(@RequestBody User user) {
//        return userService.login(user.getUsername(), user.getPassword());
//    }
}
