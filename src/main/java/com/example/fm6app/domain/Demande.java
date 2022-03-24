package com.example.fm6app.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private final Date createdAt;
    private String reference;
    private Environnement environment;
    private SituationFamiliale sf;
    private Fonction fonction;
    private Logement logement;
    private ConditionPhysique conditionPhysique;

    private String cin;
    private String AdherentCode;
    private Date naissance;
    private long age;
    private String telephone;
    private String adresseActualle;
    private String mosque;
    private String mosqueRef;

    private long anciennete;

    private int score;

    @Transient
    private List<Enfant> enfants = new ArrayList<>();

    public Demande() {
        super();
        this.score = 0;
        this.createdAt = new Date();
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Environnement getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environnement environment) {
        this.environment = environment;
    }

    public SituationFamiliale getSf() {
        return sf;
    }

    public void setSf(SituationFamiliale sf) {
        this.sf = sf;
    }

    public Fonction getFonction() {
        return fonction;
    }

    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
    }

    public Logement getLogement() {
        return logement;
    }

    public void setLogement(Logement logement) {
        this.logement = logement;
    }

    public ConditionPhysique getConditionPhysique() {
        return conditionPhysique;
    }

    public void setConditionPhysique(ConditionPhysique conditionPhysique) {
        this.conditionPhysique = conditionPhysique;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getAdherentCode() {
        return AdherentCode;
    }

    public void setAdherentCode(String adherentCode) {
        AdherentCode = adherentCode;
    }

    public Date getNaissance() {
        return naissance;
    }

    public void setNaissance(Date naissance) {
        this.naissance = naissance;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresseActualle() {
        return adresseActualle;
    }

    public void setAdresseActualle(String adresseActualle) {
        this.adresseActualle = adresseActualle;
    }

    public String getMosque() {
        return mosque;
    }

    public void setMosque(String mosque) {
        this.mosque = mosque;
    }

    public String getMosqueRef() {
        return mosqueRef;
    }

    public void setMosqueRef(String mosqueRef) {
        this.mosqueRef = mosqueRef;
    }

    public long getAnciennete() {
        return anciennete;
    }

    public void setAnciennete(long anciennete) {
        this.anciennete = anciennete;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Enfant> getEnfants() {
        return enfants;
    }

    public void setEnfants(List<Enfant> enfants) {
        this.enfants = enfants;
    }
}