package com.stephane.backend.basketball.services;

import com.stephane.backend.basketball.dto.AdresseDto;
import com.stephane.backend.basketball.entities.Adresse;
import com.stephane.backend.basketball.exception.AdresseNotFoundException;
import com.stephane.backend.basketball.exception.ErrorCode;
import com.stephane.backend.basketball.mapper.AdresseMapper;
import com.stephane.backend.basketball.repository.AdresseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdresseServiceImpl implements AdresseService {
  private final AdresseRepository repository;
  private final AdresseMapper mapper;

  @Override
  public Collection<AdresseDto> getToutesAdresses() {
    List<Adresse> all = repository.findAll();
    if (!all.isEmpty()) {
      return mapper.map(all);
    }
    throw new AdresseNotFoundException(ErrorCode.APPLICATIF, "adresseId");
  }

  @Override
  public AdresseDto getAdresseById(String adresseId) {
    Optional<Adresse> byId = repository.findById(adresseId);
    if (byId.isPresent()) {
      return mapper.map(byId.get());
    }
    throw new AdresseNotFoundException(ErrorCode.APPLICATIF, adresseId);
  }
}
