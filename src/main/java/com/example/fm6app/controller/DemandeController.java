package com.example.fm6app.controller;

import com.example.fm6app.domain.Demande;
//import com.example.fm6app.exception.ExceptionHandling;
import com.example.fm6app.domain.Fonction;
import com.example.fm6app.service.dto.DemandeDTO;
import com.example.fm6app.service.dto.ProcessDemandeDTO;
import com.example.fm6app.service.facade.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/demandes")
public class DemandeController {

    private final DemandeService demandeService;

    public DemandeController(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    @GetMapping("/codes/{code}")
    public Demande findByCodeAdherentCode(@PathVariable String code) {
        return demandeService.findByCodeAdherentCode(code);
    }

    @GetMapping("/fonctions/{fonction}")
    public Demande findByFonction(@PathVariable Fonction fonction) {
        return demandeService.findByFonction(fonction);
    }

    @GetMapping("/ages/{age}")
    public Demande findByAgeLessThanEqual(Long age) {
        return demandeService.findByAgeLessThanEqual(age);
    }

    @GetMapping("/anciennetes/{anciennete}")
    public Demande findByAncienneteLessThanEqual(@PathVariable Long anciennete) {
        return demandeService.findByAncienneteLessThanEqual(anciennete);
    }

    @GetMapping("/")
    public Page<Demande> findAll(Pageable pageable) {
        return demandeService.findAll(pageable);
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

    @PostMapping("/criteres")
    public Page<Demande> findByCriteria(@RequestBody DemandeDTO dto) {
        return demandeService.findByCriteria(dto);
    }

    @GetMapping("/reporting/{year}")
    public ResponseEntity<byte[]> generateXlsRepory(@PathVariable int year) throws IOException {
        return demandeService.generateXlsRepory(year);
    }

    @PostMapping("/process")
    public Demande processDemande(@RequestBody ProcessDemandeDTO dto) throws ParseException {
        return demandeService.processDemande(dto);
    }
}
