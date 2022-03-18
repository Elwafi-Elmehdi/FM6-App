package com.example.fm6app.config;

import com.example.fm6app.domain.Critere;
import com.example.fm6app.service.facade.CritereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapCritere implements CommandLineRunner {

    private CritereService critereService;

    @Autowired
    public BootstrapCritere(CritereService critereService) {
        this.critereService = critereService;
    }

    @Override
    public void run(String... args){
        if (critereService.findAll() == null){
            critereService.saveCritere();
        }
    }
}
