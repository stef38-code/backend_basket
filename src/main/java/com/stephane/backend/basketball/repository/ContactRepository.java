package com.stephane.backend.basketball.repository;

import com.stephane.backend.basketball.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, String> {
}
