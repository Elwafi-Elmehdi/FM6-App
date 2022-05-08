package com.example.fm6app.repository;

import com.example.fm6app.domain.Enfant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnfantRepository extends JpaRepository<Enfant,Long> {
}
