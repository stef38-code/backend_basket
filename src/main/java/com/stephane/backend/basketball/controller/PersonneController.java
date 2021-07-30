package com.stephane.backend.basketball.controller;

import com.stephane.backend.basketball.dto.PersonneDto;
import com.stephane.backend.basketball.services.PersonneServiceImpl;
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
    value = "/personnes",
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaTypes.HAL_JSON_VALUE})
@RequiredArgsConstructor
public class PersonneController {
  private final PersonneServiceImpl personneService;

  @GetMapping
  public ResponseEntity<Collection<PersonneDto>> getAllRegions() {
    return new ResponseEntity<>(personneService.getToutesPersonnes(), HttpStatus.OK);
  }

  @GetMapping("/{personneId}")
  public ResponseEntity<PersonneDto> getCustomerById(@PathVariable String personneId) {
    return new ResponseEntity<>(personneService.getPersonneById(personneId), HttpStatus.OK);
  }
}
