package com.example.fm6app.service.implementation;

import com.example.fm6app.domain.Adherent;
import com.example.fm6app.repository.AdherentRepository;
import com.example.fm6app.service.facade.AdherentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdherentServiceImplm implements AdherentService {

    private AdherentRepository repository;

    @Autowired
    public AdherentServiceImplm(AdherentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Adherent> findAll() {
        return repository.findAll();
    }
}
