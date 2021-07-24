package com.stephane.backend.basketball.repository;

import com.stephane.backend.basketball.entities.Activites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivitesRepository extends JpaRepository<Activites, String> {
}
