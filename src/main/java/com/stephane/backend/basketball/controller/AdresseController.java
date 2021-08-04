package com.stephane.backend.basketball.controller;

import com.stephane.backend.basketball.dto.AdresseDto;
import com.stephane.backend.basketball.services.AdresseService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(
    value = "/adresses",
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaTypes.HAL_JSON_VALUE})
@RequiredArgsConstructor
public class AdresseController {
  private final AdresseService adresseService;

  @GetMapping
  public ResponseEntity<Collection<AdresseDto>> getToutesLesAdresses() {
    return new ResponseEntity<>(adresseService.getToutesAdresses(), HttpStatus.OK);
  }

  @GetMapping("/{adresseId}")
  public ResponseEntity<AdresseDto> getAdresseById(@PathVariable String adresseId) {
    return new ResponseEntity<>(adresseService.getAdresseById(adresseId), HttpStatus.OK);
  }
}
