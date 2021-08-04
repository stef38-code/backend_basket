package com.stephane.backend.basketball.mapper;

import com.stephane.backend.basketball.controller.ContactController;
import com.stephane.backend.basketball.controller.PersonneController;
import com.stephane.backend.basketball.dto.ContactDto;
import com.stephane.backend.basketball.entities.Contact;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface ContactMapper extends ResourceMapper<Contact, ContactDto> {

  ContactDto map(Contact personne);

  @AfterMapping
  default void addLinks(@MappingTarget ContactDto resource, Contact entity) {
    resource.add(
        linkTo(methodOn(ContactController.class).getContactById(entity.getId())).withSelfRel());
    //
    resource.add(
        linkTo(methodOn(ContactController.class).getToutesLesContacts()).withRel("Contacts"));
    //
    entity
        .getFamille()
        .forEach(
            personne ->
                resource.add(
                    linkTo(methodOn(PersonneController.class).getPersonneById(personne.getId()))
                        .withRel(personne.getRole().toString().toLowerCase(Locale.ROOT))));
  }
}
