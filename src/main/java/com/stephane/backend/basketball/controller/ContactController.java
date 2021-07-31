package com.stephane.backend.basketball.controller;

import com.stephane.backend.basketball.dto.ContactDto;
import com.stephane.backend.basketball.services.ContactService;
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
    value = "/contacts",
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaTypes.HAL_JSON_VALUE})
@RequiredArgsConstructor
public class ContactController {
  private final ContactService contactService;

  @GetMapping
  public ResponseEntity<Collection<ContactDto>> getToutesLesContacts() {
    return new ResponseEntity<>(contactService.getToutesLesContacts(), HttpStatus.OK);
  }

  @GetMapping("/{contactId}")
  public ResponseEntity<ContactDto> getContactById(@PathVariable String contactId) {
    return new ResponseEntity<>(contactService.getContactById(contactId), HttpStatus.OK);
  }
}
