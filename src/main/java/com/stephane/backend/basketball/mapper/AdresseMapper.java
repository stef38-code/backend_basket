package com.stephane.backend.basketball.mapper;

import com.stephane.backend.basketball.controller.AdresseController;
import com.stephane.backend.basketball.controller.PersonneController;
import com.stephane.backend.basketball.dto.AdresseDto;
import com.stephane.backend.basketball.entities.Adresse;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface AdresseMapper extends ResourceMapper<Adresse, AdresseDto> {

  AdresseDto map(Adresse personne);

  @AfterMapping
  default void addLinks(@MappingTarget AdresseDto resource, Adresse entity) {
    resource.add(
        linkTo(methodOn(AdresseController.class).getAdresseById(entity.getId())).withSelfRel());
    //
    resource.add(
        linkTo(methodOn(AdresseController.class).getToutesLesAdresses()).withRel("adresses"));
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
