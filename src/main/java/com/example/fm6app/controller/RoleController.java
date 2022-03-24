package com.example.fm6app.controller;

import com.example.fm6app.domain.Role;
import com.example.fm6app.service.facade.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("/")
    public List<Role> findAll() {
        return roleService.findAll();
    }
}
