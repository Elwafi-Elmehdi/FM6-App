package com.example.fm6app.repository;

import com.example.fm6app.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByAuthority(String authority);
    int deleteByAuthority(String authority);
    List<Role> findAllByUsersUsername(String username);
}
