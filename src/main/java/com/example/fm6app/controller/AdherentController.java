package com.example.fm6app.controller;

import com.example.fm6app.domain.Adherent;
import com.example.fm6app.service.facade.AdherentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adherents")
public class AdherentController {

    private AdherentService service;

    @Autowired
    public AdherentController(AdherentService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Adherent> findAll() {
        return service.findAll();
    }
}
