package com.example.fm6app.domain;

import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Critere {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private Date createdAt;
    private Date updatedAt;

    private int valeurChaqueEnfant;
    private int anciennete;
    private int age;

    // Environnement
    private int environnementRural;
    private int environnementCivil;

    // Incapable
    private int etatPhysique;

    //Situation Familiale
    private int sfCelibataire;
    private int sfVeuf;
    private int sfMarie;
    private int sfDivorce;

    //Logement
    private int logementLouer;
    private int logementAnnexeMosque;
    private int logementFamille;

    //Fonction
    private int fonctionImame;
    private int fonctionKhatib;
    private int fonctionMoadin;
    private int fonctionGardien;
    private int fonctionMenage;
    private int fonctionObservateur;
    private int guideEncadrentPrecheur;

    public Critere() {
        this.valeurChaqueEnfant = 15;
        this.etatPhysique = 140;

        this.anciennete = 1;
        this.age = 1;

        this.environnementRural = 30;
        this.environnementCivil = 10;

        this.sfCelibataire = 10;
        this.sfVeuf = 30;
        this.sfMarie = 40;
        this.sfDivorce = 20;

        this.logementLouer = 60;
        this.logementAnnexeMosque = 40;
        this.logementFamille = 40;

        this.fonctionImame = 60;
        this.fonctionKhatib = 20;
        this.fonctionMoadin = 80;
        this.fonctionGardien = 120;
        this.fonctionMenage = 100;
        this.fonctionObservateur = 40;
        this.guideEncadrentPrecheur = 20;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValeurChaqueEnfant() {
        return valeurChaqueEnfant;
    }

    public void setValeurChaqueEnfant(int valeurChaqueEnfant) {
        this.valeurChaqueEnfant = valeurChaqueEnfant;
    }

    public int getAnciennete() {
        return anciennete;
    }

    public void setAnciennete(int anciennete) {
        this.anciennete = anciennete;
    }

    public int getEnvironnementRural() {
        return environnementRural;
    }

    public void setEnvironnementRural(int environnementRural) {
        this.environnementRural = environnementRural;
    }

    public int getEnvironnementCivil() {
        return environnementCivil;
    }

    public void setEnvironnementCivil(int environnementCivil) {
        this.environnementCivil = environnementCivil;
    }

    public int getEtatPhysique() {
        return etatPhysique;
    }

    public void setEtatPhysique(int etatPhysique) {
        this.etatPhysique = etatPhysique;
    }

    public int getSfCelibataire() {
        return sfCelibataire;
    }

    public void setSfCelibataire(int sfCelibataire) {
        this.sfCelibataire = sfCelibataire;
    }

    public int getSfVeuf() {
        return sfVeuf;
    }

    public void setSfVeuf(int sfVeuf) {
        this.sfVeuf = sfVeuf;
    }

    public int getSfMarie() {
        return sfMarie;
    }

    public void setSfMarie(int sfMarie) {
        this.sfMarie = sfMarie;
    }

    public int getSfDivorce() {
        return sfDivorce;
    }

    public void setSfDivorce(int sfDivorce) {
        this.sfDivorce = sfDivorce;
    }

    public int getLogementLouer() {
        return logementLouer;
    }

    public void setLogementLouer(int logementLouer) {
        this.logementLouer = logementLouer;
    }

    public int getLogementAnnexeMosque() {
        return logementAnnexeMosque;
    }

    public void setLogementAnnexeMosque(int logementAnnexeMosque) {
        this.logementAnnexeMosque = logementAnnexeMosque;
    }

    public int getLogementFamille() {
        return logementFamille;
    }

    public void setLogementFamille(int logementFamille) {
        this.logementFamille = logementFamille;
    }

    public int getFonctionImame() {
        return fonctionImame;
    }

    public void setFonctionImame(int fonctionImame) {
        this.fonctionImame = fonctionImame;
    }

    public int getFonctionKhatib() {
        return fonctionKhatib;
    }

    public void setFonctionKhatib(int fonctionKhatib) {
        this.fonctionKhatib = fonctionKhatib;
    }

    public int getFonctionMoadin() {
        return fonctionMoadin;
    }

    public void setFonctionMoadin(int fonctionMoadin) {
        this.fonctionMoadin = fonctionMoadin;
    }

    public int getFonctionGardien() {
        return fonctionGardien;
    }

    public void setFonctionGardien(int fonctionGardien) {
        this.fonctionGardien = fonctionGardien;
    }

    public int getFonctionMenage() {
        return fonctionMenage;
    }

    public void setFonctionMenage(int fonctionMenage) {
        this.fonctionMenage = fonctionMenage;
    }

    public int getFonctionObservateur() {
        return fonctionObservateur;
    }

    public void setFonctionObservateur(int fonctionObservateur) {
        this.fonctionObservateur = fonctionObservateur;
    }

    public int getGuideEncadrentPrecheur() {
        return guideEncadrentPrecheur;
    }

    public void setGuideEncadrentPrecheur(int guideEncadrentPrecheur) {
        this.guideEncadrentPrecheur = guideEncadrentPrecheur;
    }
}
