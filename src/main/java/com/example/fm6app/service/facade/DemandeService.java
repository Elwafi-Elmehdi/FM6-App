package com.example.fm6app.service.facade;

import com.example.fm6app.domain.Demande;
import com.example.fm6app.domain.Fonction;
import com.example.fm6app.service.dto.DemandeDTO;

import java.util.List;

public interface DemandeService {
    List<Demande> findAll();
    Demande findByCin(String cin);
    Demande findByCodeAdherentCode(String code);
    Demande findByFonction(Fonction fonction);
    Demande findByAgeLessThanEqual(long age);
    Demande findByAncienneteLessThanEqual(long age);
    Demande save(Demande demande);
    Demande delete(Demande demande);
    Demande update(Demande demande);
    List<Demande> findByCriteria(DemandeDTO dto);
}
