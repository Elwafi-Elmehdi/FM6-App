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
    private DemandeState status;

    @Temporal(TemporalType.DATE)
    private final Date createdAt;
    @Column(unique = true)
    private String reference;

    private Environnement environment;
    private SituationFamiliale sf;
    private Fonction fonction;
    private Logement logement;
    private ConditionPhysique conditionPhysique;

    private String nom;
    private String prenom;
    private String nomArabic;
    private String prenomArabic;
    private String province;
    private String rib;

    @Column(unique = true)
    private String cin;
    @Column(unique = true,updatable = false)
    private String adherentCode;
    @Temporal(TemporalType.DATE)
    private Date naissance;
    @Column(updatable = false)
    private long age;
    private String telephone;
    private String adresseActualle;
    private String mosque;
    private String mosqueRef;
    @Temporal(TemporalType.DATE)
    private Date dateJoindreMosque;
    @Column(updatable = false)
    private long anciennete;
    @Column(updatable = false)
    private int score;

    @Transient
    private List<Enfant> enfants = new ArrayList<>();

    private String commentaire;

    public Demande() {
        super();
        this.score = 0;
        this.status = DemandeState.EN_ATTENTE;
        this.createdAt = new Date();
    }

    public Date getDateJoindreMosque() {
        return dateJoindreMosque;
    }

    public void setDateJoindreMosque(Date dateJoindreMosque) {
        this.dateJoindreMosque = dateJoindreMosque;
        long diff = (new Date().getTime() - dateJoindreMosque.getTime());
        this.anciennete = ( diff / (1000L *60*60*24*365));
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public String getNomArabic() {
        return nomArabic;
    }

    public void setNomArabic(String nomArabic) {
        this.nomArabic = nomArabic;
    }

    public String getPrenomArabic() {
        return prenomArabic;
    }

    public void setPrenomArabic(String prenomArabic) {
        this.prenomArabic = prenomArabic;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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
        return adherentCode;
    }

    public void setAdherentCode(String adherentCode) {
        this.adherentCode = adherentCode;
    }

    public Date getNaissance() {
        return naissance;
    }

    public void setNaissance(Date naissance) {
        this.naissance = naissance;
        long diff = (new Date().getTime() - naissance.getTime());
        this.age = ( diff / (1000L *60*60*24*365));
    }

    public long getAge() {
        return age;
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

    public DemandeState getStatus() {
        return status;
    }

    public void setStatus(DemandeState status) {
        this.status = status;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
