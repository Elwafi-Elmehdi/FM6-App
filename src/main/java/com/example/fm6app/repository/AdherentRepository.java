package com.example.fm6app.repository;

import com.example.fm6app.domain.Adherent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdherentRepository extends JpaRepository<Adherent,Long> {
    List<Adherent> findAll();

}
