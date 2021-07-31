package com.stephane.backend.basketball.repository;

import com.stephane.backend.basketball.entities.Contact;
import com.stephane.backend.basketball.entities.constantes.TypeContact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, String> {
  Optional<Collection<Contact>> findAllByTypecontactEquals(TypeContact typecontact);
}
