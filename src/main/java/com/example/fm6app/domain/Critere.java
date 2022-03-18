package com.example.fm6app.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

@Entity
public class Critere {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonFormat(pattern = "dd-MM-yyyy@HH:mm:ss",locale = "fr_MA")
    private Date createdAt;
    @JsonFormat(pattern = "dd-MM-yyyy@HH:mm:ss",locale = "fr_MA")
    private Date updatedAt;

    @NotNull
    @Min(value = 0)
    private int valeurChaqueEnfant;

    @NotNull
    @Min(value = 0)
    private int anciennete;

    @NotNull
    @Min(value = 0)
    private int age;

    // Environnement
    @NotNull
    @Min(value = 0)
    private int environnementRural;

    @NotNull
    @Min(value = 0)
    private int environnementCivil;

    // Incapable
    @NotNull
    @Min(value = 0)
    private int etatPhysique;

    //Situation Familiale
    @NotNull
    @Min(value = 0)
    private int sfCelibataire;

    @NotNull
    @Min(value = 0)
    private int sfVeuf;

    @NotNull
    @Min(value = 0)
    private int sfMarie;

    @NotNull
    @Min(value = 0)
    private int sfDivorce;

    //Logement
    @NotNull
    @Min(value = 0)
    private int logementLouer;

    @NotNull
    @Min(value = 0)
    private int logementAnnexeMosque;

    @NotNull
    @Min(value = 0)
    private int logementFamille;

    //Fonction
    @NotNull
    @Min(value = 0)
    private int fonctionImame;

    @NotNull
    @Min(value = 0)
    private int fonctionKhatib;

    @NotNull
    @Min(value = 0)
    private int fonctionMoadin;

    @NotNull
    @Min(value = 0)
    private int fonctionGardien;

    @NotNull
    @Min(value = 0)
    private int fonctionMenage;

    @NotNull
    @Min(value = 0)
    private int fonctionObservateur;

    @NotNull
    @Min(value = 0)
    private int guideEncadrentPrecheur;

    public Critere() {
        this.createdAt = new Date();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Critere critere = (Critere) o;
        return id.equals(critere.id);
    }
}
