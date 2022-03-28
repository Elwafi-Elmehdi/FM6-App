package com.example.fm6app.service.facade;


import com.example.fm6app.domain.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User findUserByEmail(String email);
    User findUserByUsername(String username);
    User addUser(User user);
    ResponseEntity<User> login(String username, String password);
}
