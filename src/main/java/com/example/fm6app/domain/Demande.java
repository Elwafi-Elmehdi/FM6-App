package com.example.fm6app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private final Date createdAt;
    private int environment;
    private String cin;
    private String AdherentCode;
    private Date naissance;
    private int age;
    private String telephone;
    private String adresseActualle;
    private String mosque;
    private String mosqueRef;

    public Demande() {
        super();
        this.createdAt = new Date();
    }
}
