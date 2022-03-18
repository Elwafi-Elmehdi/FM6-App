package com.example.fm6app.service.implementation;

import com.example.fm6app.domain.Critere;
import com.example.fm6app.repository.CritereRepository;
import com.example.fm6app.service.facade.CritereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CritereServiceImplm implements CritereService {

    private CritereRepository critereRepository;

    @Autowired
    public CritereServiceImplm(CritereRepository critereRepository) {
        this.critereRepository = critereRepository;
    }

    @Override
    public List<Critere> findAll() {
        return critereRepository.findAll();
    }

    @Override
    public Critere getCritere() {
        return critereRepository.findAll().get(0);
    }

    @Override
    public Critere saveCritere() {
        if (isCritereEmpty()){
            Critere critere1 = new Critere();
            return critereRepository.save(critere1);
        }else {
            return null;
        }
    }

    @Override
    public Critere updateCritereById(Critere critere) {
        Optional<Critere> optionalCritere = critereRepository.findById(critere.getId());
        Critere critere1 = optionalCritere.get();
        if (critere.equals(critere1)){
            critere1.setUpdatedAt(new Date());

            critere1.setAge(critere.getAge());
            critere1.setAnciennete(critere.getAnciennete());
            critere1.setEtatPhysique(critere.getEtatPhysique());
            critere1.setValeurChaqueEnfant(critere.getValeurChaqueEnfant());

            critere1.setEnvironnementCivil(critere.getEnvironnementCivil());
            critere1.setEnvironnementRural(critere.getEnvironnementRural());

            critere1.setSfCelibataire(critere.getSfCelibataire());
            critere1.setSfDivorce(critere.getSfDivorce());
            critere1.setSfMarie(critere.getSfMarie());
            critere1.setSfVeuf(critere.getSfVeuf());

            critere1.setLogementLouer(critere.getLogementLouer());
            critere1.setLogementAnnexeMosque(critere.getLogementAnnexeMosque());
            critere1.setLogementFamille(critere.getLogementFamille());

            critere1.setFonctionImame(critere.getFonctionImame());
            critere1.setFonctionKhatib(critere.getFonctionKhatib());
            critere1.setFonctionMoadin(critere.getFonctionMoadin());
            critere1.setFonctionGardien(critere.getFonctionGardien());
            critere1.setFonctionMenage(critere.getFonctionMenage());
            critere1.setFonctionObservateur(critere.getFonctionObservateur());
            critere1.setGuideEncadrentPrecheur(critere.getGuideEncadrentPrecheur());
            return critereRepository.save(critere1);
        }
        else{
            return  null;
        }
    }
    private Boolean isCritereEmpty() {
        return critereRepository.findAll().size() == 0;
    }
}
