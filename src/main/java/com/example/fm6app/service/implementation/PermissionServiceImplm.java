package com.example.fm6app.service.implementation;

import com.example.fm6app.domain.Permission;
import com.example.fm6app.repository.PermissionRepository;
import com.example.fm6app.service.facade.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImplm implements PermissionService {
    @Autowired
    private PermissionRepository permissionDao;

    @Override
    public Permission save(Permission permission) {
        Permission perm = permissionDao.findByName(permission.getName());
        return perm == null ? permissionDao.save(permission) : perm;
    }
}
