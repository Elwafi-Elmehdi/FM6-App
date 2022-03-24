package com.example.fm6app.service.implementation;

import com.example.fm6app.domain.Role;
import com.example.fm6app.domain.UserAdherent;
import com.example.fm6app.repository.UserRepository;
import com.example.fm6app.service.facade.RoleService;
import com.example.fm6app.service.facade.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImplm implements UserService {

    @Autowired
    private UserRepository userDao;

    @Autowired
    private RoleService roleService;

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<UserAdherent> findAll() {
        return userDao.findAll();
    }

    @Override
    public UserAdherent findByUsername(String username) {
        if (username == null)
            return null;
        return userDao.findByUsername(username);
    }

    @Override
    public UserAdherent findByUsernameWithRoles(String username) {
        if (username == null)
            return null;
        return userDao.findByUsername(username);
    }

    @Override
    @Transactional
    public int deleteByUsername(String username) {
        return userDao.deleteByUsername(username);
    }

    @Override
    public UserAdherent findById(Long id) {
        if (id == null)
            return null;
        return userDao.getOne(id);
    }

    @Transactional
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public UserAdherent save(UserAdherent user) {
        UserAdherent foundedUserByUsername = findByUsername(user.getUsername());
        UserAdherent foundedUserByEmail = userDao.findByEmail(user.getEmail());
        if (foundedUserByUsername != null || foundedUserByEmail != null) return null;
        else {
            if (user.getPassword() == null || user.getPassword().isEmpty()) {
                user.setPassword((user.getUsername()));
            }
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
            user.setEnabled(true);
            user.setPasswordChanged(false);
            user.setCreatedAt(new Date());

            if (user.getRoles() != null) {
                Collection<Role> roles = new ArrayList<>();
                for (Role role : user.getRoles()) {
                    roles.add(roleService.save(role));
                }
                user.setRoles(roles);
            }
            UserAdherent mySaved = userDao.save(user);

            return mySaved;
        }
    }

    @Override
    public UserAdherent update(UserAdherent user) {
        UserAdherent foundedUser = findById(user.getId());
        if (foundedUser == null) return null;
        else {
            foundedUser.setEmail(user.getEmail());
            foundedUser.setUsername(user.getUsername());
            foundedUser.setFirstName(user.getFirstName());
            foundedUser.setLastName(user.getLastName());
            foundedUser.setEnabled(user.isEnabled());
            foundedUser.setCredentialsNonExpired(user.isCredentialsNonExpired());
            foundedUser.setAccountNonLocked(user.isAccountNonLocked());
            foundedUser.setAccountNonExpired(user.isAccountNonExpired());
            foundedUser.setAuthorities(new ArrayList<>());
            Collection<Role> roles = new ArrayList<Role>();
            for (Role role : user.getRoles()) {
                roles.add(roleService.save(role));
            }
            foundedUser.setRoles(roles);
            return userDao.save(foundedUser);
        }
    }

    @Override
    @Transactional
    public int delete(Long id) {
        UserAdherent foundedUser = findById(id);
        if (foundedUser == null) return -1;
        userDao.delete(foundedUser);
        return 1;
    }

    @Override
    public UserAdherent loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUsernameWithRoles(username);
    }

}
