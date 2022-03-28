package com.example.fm6app.service.facade;


import com.example.fm6app.domain.User;
import com.example.fm6app.exception.UsernameExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getUsers();
    User findUserByEmail(String email);
    User findUserByUsername(String username);
    User addUser(User user) throws UsernameExistsException;
    ResponseEntity<User> login(String username, String password);
}
