package com.stephane.backend.basketball.mapper;

import com.stephane.backend.basketball.controller.AdresseController;
import com.stephane.backend.basketball.controller.ContactController;
import com.stephane.backend.basketball.controller.PersonneController;
import com.stephane.backend.basketball.dto.PersonneDto;
import com.stephane.backend.basketball.entities.Personne;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Mapper(componentModel = "spring")

public interface PersonneMapper extends ResourceMapper<Personne, PersonneDto> {

  PersonneDto map(Personne personne);

  @AfterMapping
  default void addLinks(@MappingTarget PersonneDto resource, Personne entity) {
    resource.add(
        linkTo(
                methodOn(PersonneController.class)
                    .getPersonneDetailsById(entity.getId()))
            .withSelfRel());
    //
    resource.add(
        linkTo(
                methodOn(PersonneController.class).getToutesPersonnes())
            .withRel("Personnes"));

/*      resource.add(linkTo(methodOn(PersonneController.class)
              .miseAJourPersonne(PersonneDetailsDto, entity.getId()))
              .withRel("miseAJours"));*/
      resource.add(linkTo(methodOn(PersonneController.class)
              .supprimerPersonneById(entity.getId()))
              .withRel("Supprimer"));
    // Personne
    entity.getFamille()
        .forEach(
            parent ->
                resource.add(
                    linkTo(
                            methodOn(PersonneController.class)
                                .getPersonneById(parent.getId()))
                        .withRel(parent.getRole().toString().toLowerCase(Locale.ROOT))));
    // Les adresses
    entity.getAdresses()
        .forEach(
            adresse ->
                resource.add(
                    linkTo(
                            methodOn(AdresseController.class)
                                .getAdresseById(adresse.getId()))
                        .withRel("Adresses")));
    // Les contacts
    entity.getContacts()
        .forEach(
            contact -> {
              String libelle =
                  contact
                      .getTypecontact()
                      .toString()
                      .toLowerCase(Locale.ROOT)
                      .concat("_")
                      .concat(contact.getNaturecontact().toString().toLowerCase(Locale.ROOT));
              resource.add(
                  linkTo(
                          methodOn(ContactController.class)
                              .getContactById(contact.getId()))
                      .withRel(libelle));
            });
  }
}
