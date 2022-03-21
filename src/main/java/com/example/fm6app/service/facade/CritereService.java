package com.example.fm6app.service.facade;

import com.example.fm6app.domain.Critere;

import java.util.List;

public interface CritereService {
    List<Critere> findAll();
    Critere saveCritere();
    Critere updateCritereById(Critere critere);
}
