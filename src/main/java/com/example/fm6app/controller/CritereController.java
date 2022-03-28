package com.example.fm6app.controller;

import com.example.fm6app.domain.Critere;
import com.example.fm6app.exception.ExceptionHandling;
import com.example.fm6app.service.facade.CritereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/criteres")
public class CritereController extends ExceptionHandling {
    private CritereService critereService;
    @Autowired
    public CritereController(CritereService critereService) {
        this.critereService = critereService;
    }

    @GetMapping("/")
    public List<Critere> findAll() {
        return critereService.findAll();
    }
    @PutMapping("/")
    public Critere updateCritereById(@RequestBody Critere critere) {
        return critereService.updateCritereById(critere);
    }

    @GetMapping("/global")
    public Critere findOne() {
        return critereService.findOne();
    }
}
