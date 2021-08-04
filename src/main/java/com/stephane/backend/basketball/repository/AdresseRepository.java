package com.stephane.backend.basketball.repository;

import com.stephane.backend.basketball.entities.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresseRepository extends JpaRepository<Adresse, String> {
}
