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
    private int environment;
    private String cin;
    private String AdherentCode;
    private Date naissance;
    private int age;
    private String telephone;
    private String adresseActualle;
    private String mosque;
    private String mosqueRef;
    private int score;

    @Transient
    private List<Enfant> enfants = new ArrayList<>();

    public Demande() {
        super();
        this.score = 0;
        this.createdAt = new Date();
    }
}