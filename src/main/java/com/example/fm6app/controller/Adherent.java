package com.example.fm6app.controller;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Adherent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    @NotNull
    @NotBlank(message = "Le nom est obligatoire")
    private String prenom;

    @NotBlank(message = "L'adresse est obligatoire")
    private String adresse;

    @Max(value = 130,message = "L'age est non valid")
    @Min(value = 18,message = "L'age est non valid")
    @NotBlank(message = "Le nom est obligatoire")
    private Integer age;

}