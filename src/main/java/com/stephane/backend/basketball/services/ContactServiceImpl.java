package com.stephane.backend.basketball.services;

import com.stephane.backend.basketball.dto.ContactDto;
import com.stephane.backend.basketball.entities.Contact;
import com.stephane.backend.basketball.entities.constantes.TypeContact;
import com.stephane.backend.basketball.exception.ContactNotFoundException;
import com.stephane.backend.basketball.exception.ErrorCode;
import com.stephane.backend.basketball.mapper.ContactMapper;
import com.stephane.backend.basketball.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ContactServiceImpl implements ContactService {
  public static final String CONTACT_ID = "contactId";
  private final ContactRepository repository;
  private final ContactMapper mapper;

  @Override
  public Collection<ContactDto> getToutesLesContacts() {
    List<Contact> all = repository.findAll();
    if (!all.isEmpty()) {
      return mapper.map(all);
    }
    throw new ContactNotFoundException(ErrorCode.APPLICATIF, CONTACT_ID);
  }

  @Override
  public ContactDto getContactById(String contactId) {
    Optional<Contact> byId = repository.findById(contactId);
    if (byId.isPresent()) {
      return mapper.map(byId.get());
    }
    throw new ContactNotFoundException(ErrorCode.APPLICATIF, contactId);
  }

  @Override
  public Collection<ContactDto> getToutesLesContactsEmails() {
    List<Contact> all = repository.findAllByTypecontactEquals(TypeContact.EMAIL);
    if (!all.isEmpty()) {
      return mapper.map(all);
    }
    throw new ContactNotFoundException(ErrorCode.APPLICATIF, CONTACT_ID);
  }

  @Override
  public Collection<ContactDto> getToutesLesContactsTelephonesPortable() {
    List<Contact> all = repository.findAllByTypecontactEquals(TypeContact.TEL_PORTABLE);
    if (!all.isEmpty()) {
      return mapper.map(all);
    }
    throw new ContactNotFoundException(ErrorCode.APPLICATIF, CONTACT_ID);
  }
  @Override
  public Collection<ContactDto> getToutesLesContactsTelephonesFixe() {
    List<Contact> all = repository.findAllByTypecontactEquals(TypeContact.TEL_FIXE);
    if (!all.isEmpty()) {
      return mapper.map(all);
    }
    throw new ContactNotFoundException(ErrorCode.APPLICATIF, CONTACT_ID);
  }

}
