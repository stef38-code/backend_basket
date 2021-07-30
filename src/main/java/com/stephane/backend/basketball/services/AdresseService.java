package com.stephane.backend.basketball.services;

import com.stephane.backend.basketball.dto.AdresseDto;

import java.util.Collection;

public interface AdresseService {
  Collection<AdresseDto> getToutesAdresses();

  AdresseDto getAdresseById(String adresseId);
}
