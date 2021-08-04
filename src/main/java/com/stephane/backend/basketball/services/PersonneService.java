package com.stephane.backend.basketball.services;

import com.stephane.backend.basketball.dto.PersonneDetailsDto;
import com.stephane.backend.basketball.dto.PersonneDto;

import java.util.Collection;

public interface PersonneService {
    PersonneDto getPersonneById(String personneId);
    Collection<PersonneDto> getToutesPersonnes();
    PersonneDetailsDto getPersonneDetailsById(String personneId);
    void SupprimerPersonneById(String personneId);
}
