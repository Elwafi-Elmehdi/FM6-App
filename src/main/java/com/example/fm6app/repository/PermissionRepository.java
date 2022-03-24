package com.example.fm6app.repository;

import com.example.fm6app.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authentication.jaas.JaasPasswordCallbackHandler;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,Long> {
    public Permission findByName(String name);
}
