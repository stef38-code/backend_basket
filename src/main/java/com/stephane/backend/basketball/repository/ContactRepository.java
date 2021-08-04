package com.stephane.backend.basketball.repository;

import com.stephane.backend.basketball.entities.Contact;
import com.stephane.backend.basketball.entities.constantes.TypeContact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, String> {
  List<Contact> findAllByTypecontactEquals(TypeContact typecontact);
}
