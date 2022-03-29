package com.example.fm6app.repository;

import com.example.fm6app.domain.Demande;
import com.example.fm6app.domain.Fonction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeRepository extends JpaRepository<Demande,Long> {
    Demande findByCin(String cin);
    Demande findByAdherentCode(String code);
    Demande findByFonction(Fonction fonction);
    Demande findByAgeIsLessThanEqual(Long age);
    Demande findByAncienneteIsLessThanEqual(Long anciennete);
}
