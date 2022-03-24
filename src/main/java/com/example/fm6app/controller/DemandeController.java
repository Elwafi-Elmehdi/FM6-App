package com.example.fm6app.controller;

import com.example.fm6app.domain.Demande;
import com.example.fm6app.service.facade.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demandes")
public class DemandeController {

    private DemandeService demandeService;

    @Autowired
    public DemandeController(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    @GetMapping("/")
    public List<Demande> findAll() {
        return demandeService.findAll();
    }
    @GetMapping("/cin/{cin}")
    public Demande findByCin(@PathVariable String cin) {
        return demandeService.findByCin(cin);
    }
    @PostMapping("/")
    public Demande save(@RequestBody Demande demande) {
        return demandeService.save(demande);
    }
    @DeleteMapping("/")
    public Demande delete(@RequestBody Demande demande) {
        return demandeService.delete(demande);
    }
    @PutMapping("/")
    public Demande update(@RequestBody Demande demande) {
        return demandeService.update(demande);
    }
}
