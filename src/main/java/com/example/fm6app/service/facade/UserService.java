package com.example.fm6app.service.facade;

import com.example.fm6app.domain.UserAdherent;
import org.apache.catalina.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserAdherent> findAll();

    UserAdherent findByUsername(String username);

    UserAdherent findById(Long id);

    void deleteById(Long id);

    UserAdherent save(UserAdherent user);

    UserAdherent update(UserAdherent user);

    int delete(Long id);

    UserAdherent findByUsernameWithRoles(String username);

    int  deleteByUsername(String username);

    UserAdherent loadUserByUsername(String username)  ;
}
