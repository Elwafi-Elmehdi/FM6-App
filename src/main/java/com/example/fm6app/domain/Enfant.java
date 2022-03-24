package com.example.fm6app.domain;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class Enfant {
    private Date naissance;
    private long age;

    public Date getNaissance() {
        return naissance;
    }

    public void setNaissance(Date naissance) {
        this.naissance = naissance;
        long diff = (new Date().getTime() - naissance.getTime());
        this.age = ( diff / (1000l*60*60*24*365));
    }

    public long getAge() {
        return age;
    }

    public Enfant(){
        super();
    }
}
