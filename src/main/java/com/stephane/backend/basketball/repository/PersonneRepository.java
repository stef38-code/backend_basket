package com.stephane.backend.basketball.repository;

import com.stephane.backend.basketball.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  PersonneRepository extends JpaRepository<Personne,String> {
}
