package com.stephane.backend.basketball.controller;

import com.stephane.backend.basketball.dto.PersonneDetailsDto;
import com.stephane.backend.basketball.dto.PersonneDto;
import com.stephane.backend.basketball.services.PersonneServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@RestController
@RequestMapping(
    value = "/personnes",
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaTypes.HAL_JSON_VALUE})
@RequiredArgsConstructor
public class PersonneController {
  private final PersonneServiceImpl personneService;

  @GetMapping
  public ResponseEntity<Collection<PersonneDto>> getToutesPersonnes() {
    return new ResponseEntity<>(personneService.getToutesPersonnes(), HttpStatus.OK);
  }

  @GetMapping("/{personneId}")
  public ResponseEntity<PersonneDto> getPersonneById(@PathVariable String personneId) {
    return new ResponseEntity<>(personneService.getPersonneById(personneId), HttpStatus.OK);
  }
  @DeleteMapping("/{personneId}")
  public ResponseEntity<Void> supprimerPersonneById(@PathVariable String personneId) {
    personneService.supprimerPersonneById(personneId);
    return new ResponseEntity<>( HttpStatus.OK);
  }
  @GetMapping("/{personneId}/details")
  public ResponseEntity<PersonneDetailsDto> getPersonneDetailsById(@NotEmpty @PathVariable String personneId) {
    return new ResponseEntity<>(personneService.getPersonneDetailsById(personneId), HttpStatus.OK);
  }
}
