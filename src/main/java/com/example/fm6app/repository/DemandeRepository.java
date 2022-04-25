package com.example.fm6app.repository;

import com.example.fm6app.domain.Demande;
import com.example.fm6app.domain.Fonction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeRepository extends JpaRepository<Demande,Long> {

    Page<Demande> findAll(Pageable pageable);

    Demande findByCin(String cin);
    Demande findByAdherentCode(String code);
    Demande findByFonction(Fonction fonction);
    Demande findByAgeIsLessThanEqual(Long age);
    Demande findByAncienneteIsLessThanEqual(Long anciennete);

    @Query(value = "SELECT * FROM demande  WHERE created_at LIKE %?1% ORDER BY score DESC",nativeQuery = true)
    List<Demande> findByDateCustom(@Param("created_at") int year);
}
