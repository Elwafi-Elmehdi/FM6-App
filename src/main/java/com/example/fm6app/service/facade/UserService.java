package com.example.fm6app.service.facade;


import com.example.fm6app.domain.User;

import java.util.List;

public interface UserService {
    public List<User> getUsers();
    public User findUserByEmail(String email);
    public User findUserByUsername(String username);
}
