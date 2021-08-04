package com.stephane.backend.basketball.services;

import com.stephane.backend.basketball.dto.PersonneDetailsDto;
import com.stephane.backend.basketball.dto.PersonneDto;
import com.stephane.backend.basketball.entities.Personne;
import com.stephane.backend.basketball.exception.ErrorCode;
import com.stephane.backend.basketball.exception.PersonneNotFoundException;
import com.stephane.backend.basketball.mapper.PersonneDetailsMapper;
import com.stephane.backend.basketball.mapper.PersonneMapper;
import com.stephane.backend.basketball.repository.PersonneRepository;
import io.micrometer.core.instrument.util.StringUtils;
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
  private final PersonneDetailsMapper mapperDetails;
  @Override
  public PersonneDto getPersonneById(String personneId) {
    Optional<Personne> byId = repository.findById(personneId);
    if (byId.isPresent()) {
      return mapper.map(byId.get());
    }
    throw new PersonneNotFoundException(ErrorCode.APPLICATIF, personneId);
  }
  @Override
  public Collection<PersonneDto> getToutesPersonnes() {
    List<Personne> all = repository.findAll();
    if (!all.isEmpty()) {
      return mapper.map(all);
    }
    throw new PersonneNotFoundException(ErrorCode.APPLICATIF, "personneId");
  }

  @Override
  public PersonneDetailsDto getPersonneDetailsById(String personneId) {
    Optional<Personne> byId = repository.findById(personneId);
    if (byId.isPresent()) {
      return mapperDetails.map(byId.get());
    }
    throw new PersonneNotFoundException(ErrorCode.APPLICATIF, personneId);
  }

  @Override
  public void SupprimerPersonneById(String personneId) {
    if (StringUtils.isBlank(personneId)) {
      throw new PersonneNotFoundException(ErrorCode.APPLICATIF, personneId);
    }
    repository.deleteById(personneId);
  }
}
