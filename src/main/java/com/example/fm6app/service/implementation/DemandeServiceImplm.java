package com.example.fm6app.service.implementation;

import com.example.fm6app.domain.Critere;
import com.example.fm6app.domain.Demande;
import com.example.fm6app.domain.Enfant;
import com.example.fm6app.domain.Fonction;
import com.example.fm6app.repository.DemandeRepository;
import com.example.fm6app.service.facade.CritereService;
import com.example.fm6app.service.facade.DemandeService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DemandeServiceImplm implements DemandeService {

    private DemandeRepository demandeRepo;
    private CritereService critereService;
    private Critere critere;

    @Autowired
    public DemandeServiceImplm(DemandeRepository demandeRepo,CritereService critereService) {
        this.demandeRepo = demandeRepo;
        this.critereService = critereService;
        this.critere = critereService.findAll().get(0);
    }

    @Override
    public List<Demande> findAll() {
        return demandeRepo.findAll();
    }

    @Override
    public Demande findByCin(String cin) {
        return demandeRepo.findByCin(cin);
    }

    @Override
    public Demande findByCodeAdherentCode(String code) {
        return demandeRepo.findByAdherentCode(code);
    }

    @Override
    public Demande findByFonction(Fonction fonction) {
        return demandeRepo.findByFonction(fonction);
    }

    @Override
    public Demande findByAgeLessThanEqual(long age) {
        return demandeRepo.findByAgeIsLessThanEqual(age);
    }

    @Override
    public Demande findByAncienneteLessThanEqual(long anciennete) {
        return demandeRepo.findByAncienneteIsLessThanEqual(anciennete);
    }
    @Transactional
    @Override
    public Demande save(Demande demande) {
        if(demandeRepo.findByCin(demande.getCin()) != null)
            return null;
        else{
            demande = generateDemande(demande);
            demande.setScore(generateScore(demande));
            return demandeRepo.save(demande);
        }
    }
    @Transactional
    @Override
    public Demande delete(Demande demande) {
        if(demandeRepo.findById(demande.getId()).get() == null)
            return null;
        else{
            demandeRepo.deleteById(demande.getId());
            return demande;
        }
    }
    @Transactional
    @Override
    public Demande update(Demande demande) {
        Optional<Demande> dbDemande = demandeRepo.findById(demande.getId());
        if(dbDemande.isEmpty()){
            return null;
        }else if (!dbDemande.get().getCin().equalsIgnoreCase(demande.getCin()))
            return  null;
        else{
            return demandeRepo.save(demande);
        }
    }

    private int generateScore(Demande demande) {
        int score = 0;
        score += getEnvironementScore(demande);
        score += getLogementScore(demande);
        score += getSfScore(demande);
        score += getFonctionScore(demande);
        score += getConditionPhysiqueScore(demande);
        score += getEnfantsScore(demande);
        score += getAncienneteAndAge(demande);
        return score;
    }

    private Demande generateDemande(Demande demande){

        Demande demandeDao = new Demande();
        demandeDao.setReference(demande.getCin()+ RandomStringUtils.randomAlphanumeric(5));
        demandeDao.setNaissance(demande.getNaissance());
        demandeDao.setNom(demande.getNom());
        demandeDao.setPrenom(demande.getPrenom());
        demandeDao.setCin(demande.getCin());
        demandeDao.setAdherentCode(demande.getAdherentCode());
        demandeDao.setTelephone(demande.getTelephone());
        demandeDao.setAdresseActualle(demande.getAdresseActualle());
        demandeDao.setMosque(demande.getMosque());
        demandeDao.setMosqueRef(demande.getMosqueRef());
        demandeDao.setDateJoindreMosque(demande.getDateJoindreMosque());

        demandeDao.setEnvironment(demande.getEnvironment());
        demandeDao.setSf(demande.getSf());
        demandeDao.setFonction(demande.getFonction());
        demandeDao.setConditionPhysique(demande.getConditionPhysique());
        demandeDao.setLogement(demande.getLogement());

        return demandeDao;
    }


    private int getFonctionScore(Demande demande){
        switch (demande.getFonction()){
            case IMAME:
                return critere.getFonctionImame();
            case KHATIB:
                return critere.getFonctionKhatib();
            case GARDIEN:
                return critere.getFonctionGardien();
            case MENAGE:
                return critere.getFonctionMenage();
            case MOADIN:
                return critere.getFonctionMoadin();
            case PRECHEUR:
                return critere.getFonctionObservateur();
            default:
                return 0;
        }
    }

    private int getSfScore(Demande demande){
        switch (demande.getSf()){
            case VEUF:
                return critere.getSfVeuf();
            case MARIE:
                return critere.getSfMarie();
            case DIVORCE:
                return critere.getSfDivorce();
            case CELIBATAIRE:
                return critere.getSfCelibataire();
            default:
                return 0;
        }
    }

    private int getLogementScore(Demande demande){
        switch (demande.getLogement()){
            case LOUER:
                return critere.getLogementLouer();
            case FAMILLE:
                return critere.getLogementFamille();
            case ANNEXE_MOSQUE:
                return critere.getLogementAnnexeMosque();
            default:
                return 0;
        }
    }
    private int getEnvironementScore(Demande demande){
        switch (demande.getEnvironment()){
            case CIVIL:
                return critere.getEnvironnementCivil();
            case RURAL:
                return critere.getEnvironnementRural();
            default:
                return  0;
        }
    }


    private int getConditionPhysiqueScore(Demande demande){
        switch (demande.getConditionPhysique()){
            case INCAPABLE:
                return critere.getEtatPhysique();
            default:
                return 0;
        }
    }

    private int getEnfantsScore(Demande demande)  {
        int enfantsScore = 0;
        try {
            for(Enfant enf : demande.getEnfants()){
                setEnfAge(enf);
                if(enf.getAge() <=0 || enf.getAge() >= 25){
                    throw new Exception("Age est non valid");
                }
                else {
                    enfantsScore += critere.getValeurChaqueEnfant();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return enfantsScore;
    }
    private int getAncienneteAndAge(Demande demande){
        int score = 0;
        try{
            score = ((int)demande.getAnciennete() * critere.getAnciennete())
                    + ((int)demande.getAge() * critere.getAge());
        }catch (Exception e){
            e.printStackTrace();
        }
        return score;
    }
    private void setEnfAge(Enfant enf){
        enf.setNaissance(enf.getNaissance());
    }
}
