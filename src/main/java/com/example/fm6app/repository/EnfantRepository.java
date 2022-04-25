package com.example.fm6app.repository;

import com.example.fm6app.domain.Enfant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnfantRepository extends JpaRepository<Enfant,Long> {
}
