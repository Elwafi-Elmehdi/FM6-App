package com.example.fm6app.service.implementation;

import com.example.fm6app.domain.User;
import com.example.fm6app.domain.UserPrinciple;
import com.example.fm6app.repository.UserRepository;
import com.example.fm6app.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class UserServiceImplm implements UserDetailsService, UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        if(user == null )
            throw new UsernameNotFoundException("Cannot find User with "+ s);
        else{
            user.setLastLoginDateDisplay(user.getLastLoginDate());
            user.setLastLoginDate(new Date());
            userRepository.save(user);
            UserPrinciple userPrinciple = new UserPrinciple(user);
            return userPrinciple;
        }
    }
}
