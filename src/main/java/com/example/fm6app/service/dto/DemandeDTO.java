package com.example.fm6app.service.dto;

import com.example.fm6app.domain.Fonction;

public class DemandeDTO {
    private String cin;
    private String codeAdherent;
    private String telephone;
    private int age;
    private int anciennete;
    private Fonction fonction;

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getCodeAdherent() {
        return codeAdherent;
    }

    public void setCodeAdherent(String codeAdherent) {
        this.codeAdherent = codeAdherent;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAnciennete() {
        return anciennete;
    }

    public void setAnciennete(int anciennete) {
        this.anciennete = anciennete;
    }

    public Fonction getFonction() {
        return fonction;
    }

    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
    }
}
