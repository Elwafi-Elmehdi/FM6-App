package com.example.fm6app.service.implementation;

import com.example.fm6app.common.security.JWTTokenProvider;
import com.example.fm6app.domain.Role;
import com.example.fm6app.domain.User;
import com.example.fm6app.domain.UserPrinciple;
import com.example.fm6app.exception.UsernameExistsException;
import com.example.fm6app.repository.UserRepository;
import com.example.fm6app.service.facade.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UserServiceImplm implements UserDetailsService, UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private JWTTokenProvider jwtTokenProvider;

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(getClass());

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
    public User addUser(User user) {
        validateEmailAndUsername(StringUtils.EMPTY,user.getUsername());

        String password = generatePassword();
        user.setPassword(encodePassword(password));
        user.setUserId(genrateUserId());
        user.setJoinDate(new Date());
        user.setLastLoginDate(null);
        user.setLastLoginDateDisplay(null);
        user.setRole(getRoleEnumName(user.getRole()).name());
        user.setAuthorities(getRoleEnumName(user.getRole()).getAuthorities());
        userRepository.save(user);
        LOGGER.info(user.getUsername()+" "+password);
        return user;
    }

    @Override
    public ResponseEntity<User> login(String username, String password) {
        return null;
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
    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    private String genrateUserId() {
        return  RandomStringUtils.randomNumeric(10);
    }

    private String generatePassword() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
    private Role getRoleEnumName(String role) {
        return Role.valueOf(role.toUpperCase());
    }
    private User validateEmailAndUsername(String currentUsername, String username) throws UsernameExistsException, EmailExistsException {
        User userByUsername = findUserByUsername(username);

        if(StringUtils.isNotBlank(currentUsername)){
            User currentUser = findUserByUsername(currentUsername);
            if(currentUser == null){
                throw new UsernameNotFoundException("No user found with username"+ currentUsername);
            }
            if(userByUsername!= null && !currentUser.getId().equals(userByUsername.getId())){
                throw new UsernameExistsException("Username already exists");
            }
            return currentUser;
        }else {
            if(userByUsername != null){
                throw new UsernameExistsException("Username already exists");
            }
            return null;
        }
    }
}
