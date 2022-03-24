package com.example.fm6app.service.facade;

import com.example.fm6app.domain.Demande;

import java.util.List;

public interface DemandeService {
    List<Demande> findAll();
    Demande findByCin(String cin);
    Demande save(Demande demande);
    Demande delete(Demande demande);
}
