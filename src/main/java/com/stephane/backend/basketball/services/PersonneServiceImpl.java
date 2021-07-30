package com.stephane.backend.basketball.services;

import com.stephane.backend.basketball.dto.PersonneDto;
import com.stephane.backend.basketball.entities.Personne;
import com.stephane.backend.basketball.exception.ErrorCode;
import com.stephane.backend.basketball.exception.PersonneNotFoundException;
import com.stephane.backend.basketball.mapper.PersonneMapper;
import com.stephane.backend.basketball.repository.PersonneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonneServiceImpl implements PersonneService {
  private final PersonneRepository repository;
  private final PersonneMapper mapper;

  public PersonneDto getPersonneById(String personneId) {
    Optional<Personne> byId = repository.findById(personneId);
    if (byId.isPresent()) {
      return mapper.map(byId.get());
    }
    throw new PersonneNotFoundException(ErrorCode.APPLICATIF, personneId);
  }

  public Collection<PersonneDto> getToutesPersonnes() {
    List<Personne> all = repository.findAll();
    if (!all.isEmpty()) {
      return mapper.map(all);
    }
    throw new PersonneNotFoundException(ErrorCode.APPLICATIF, "personneId");
  }
}
