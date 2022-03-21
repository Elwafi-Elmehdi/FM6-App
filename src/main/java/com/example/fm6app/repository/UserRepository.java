package com.example.fm6app.repository;

import com.example.fm6app.domain.UserAdherent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserAdherent,Long> {
    UserAdherent findByUsername(String username);
    int deleteByUsername(String username);
    UserAdherent findByEmail(String email);
}
