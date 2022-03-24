package com.example.fm6app.service.implementation;

import com.example.fm6app.domain.Demande;
import com.example.fm6app.repository.DemandeRepository;
import com.example.fm6app.service.facade.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DemandeServiceImplm implements DemandeService {

    private DemandeRepository demandeRepo;

    @Autowired
    public DemandeServiceImplm(DemandeRepository demandeRepo) {
        this.demandeRepo = demandeRepo;
    }

    @Override
    public List<Demande> findAll() {
        return demandeRepo.findAll();
    }

    @Override
    public List<Demande> findByCin(String cin) {
        return demandeRepo.findByCin(cin);
    }

    @Override
    public Demande save(Demande demande) {
        if(demandeRepo.findById(demande.getId()).get() != null)
            return null;
        else{

            return demande;
        }
    }

    @Override
    public Demande delete(Demande demande) {
        if(demandeRepo.findById(demande.getId()).get() == null)
            return null;
        else{
        demandeRepo.deleteById(demande.getId());
            return demande;
        }
    }
}
