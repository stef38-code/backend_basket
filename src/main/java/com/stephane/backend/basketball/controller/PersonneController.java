package com.stephane.backend.basketball.controller;

import com.stephane.backend.basketball.dto.PersonneDto;
import com.stephane.backend.basketball.services.PersonneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "/personnes")
@RequiredArgsConstructor
public class PersonneController {
    private final PersonneService personneService;

    @GetMapping
    public ResponseEntity<Collection<PersonneDto>> getAllRegions() {
        return new ResponseEntity<>(personneService.getAllPersonnes(), HttpStatus.OK);
    }

    @GetMapping("/{personneId}")
    public ResponseEntity<PersonneDto> getCustomerById(@PathVariable String personneId) {
        return new ResponseEntity<>(personneService.getPersonneDetails(personneId), HttpStatus.OK);
    }
}
