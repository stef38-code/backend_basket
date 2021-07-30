package com.stephane.backend.basketball.mapper;

import com.stephane.backend.basketball.controller.AdresseController;
import com.stephane.backend.basketball.dto.AdresseDto;
import com.stephane.backend.basketball.entities.Adresse;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@Mapper(componentModel = "spring")
public interface AdresseMapper extends ResourceMapper<Adresse, AdresseDto> {

  AdresseDto map(Adresse personne);

  @AfterMapping
  default void addLinks(@MappingTarget AdresseDto resource, Adresse entity) {
    // WebMvcLinkBuilder linkBuilder =
    // WebMvcLinkBuilder.linkTo(PersonneController.class).slash(entity.getId());
    resource.add(
        WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(AdresseController.class).getAdresseById(entity.getId()))
            .withSelfRel());
    /*//
    resource.add(WebMvcLinkBuilder.linkTo(
            WebMvcLinkBuilder.methodOn(PersonneController.class).getAllRegions()
    ).withRel("personnes"));
    //
    entity.getFamille().stream().forEach(
            parent ->   resource.add(WebMvcLinkBuilder.linkTo(
                    WebMvcLinkBuilder.methodOn(PersonneController.class).getCustomerById(entity.getId())
                    ).withRel(parent.getRole().toString().toLowerCase(Locale.ROOT)))
    );*/
  }
}
