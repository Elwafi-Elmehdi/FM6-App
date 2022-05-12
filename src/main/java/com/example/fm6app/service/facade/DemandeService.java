package com.example.fm6app.service.facade;

import com.example.fm6app.domain.Demande;
import com.example.fm6app.domain.Fonction;
import com.example.fm6app.service.dto.DemandeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface DemandeService {
    Page<Demande> findAll(Pageable pageable);
    Demande findByCin(String cin);
    Demande findByCodeAdherentCode(String code);
    Demande findByFonction(Fonction fonction);
    Demande findByAgeLessThanEqual(long age);
    Demande findByAncienneteLessThanEqual(long age);
    Demande save(Demande demande);
    Demande delete(Demande demande);
    Demande update(Demande demande);
    Page<Demande> findByCriteria(DemandeDTO dto);
    ResponseEntity<byte[]> generateXlsRepory(int year) throws IOException;
    Demande processDemande(Long id);
}
