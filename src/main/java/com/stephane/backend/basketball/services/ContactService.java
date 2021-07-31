package com.stephane.backend.basketball.services;

import com.stephane.backend.basketball.dto.ContactDto;

import java.util.Collection;

public interface ContactService {
  Collection<ContactDto> getToutesLesContacts();

  ContactDto getContactById(String contactId);

  Collection<ContactDto> getToutesLesContactsEmails();
}
