package com.example.fm6app.domain;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Enfant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date naissance;
    private long age;

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

    public Enfant(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
