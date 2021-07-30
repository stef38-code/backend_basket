package com.stephane.backend.basketball.mapper;

import com.stephane.backend.basketball.controller.PersonneController;
import com.stephane.backend.basketball.dto.PersonneDto;
import com.stephane.backend.basketball.entities.Personne;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.Locale;

@Mapper(componentModel = "spring")
public interface PersonneMapper extends ResourceMapper<Personne, PersonneDto> {

  PersonneDto map(Personne personne);

  @AfterMapping
  default void addLinks(@MappingTarget PersonneDto resource, Personne entity) {
    // WebMvcLinkBuilder linkBuilder =
    // WebMvcLinkBuilder.linkTo(PersonneController.class).slash(entity.getId());
    resource.add(
        WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(PersonneController.class)
                    .getCustomerById(entity.getId()))
            .withSelfRel());
    //
    resource.add(
        WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(PersonneController.class).getAllRegions())
            .withRel("personnes"));
    //
    entity.getFamille().stream()
        .forEach(
            parent ->
                resource.add(
                    WebMvcLinkBuilder.linkTo(
                            WebMvcLinkBuilder.methodOn(PersonneController.class)
                                .getCustomerById(entity.getId()))
                        .withRel(parent.getRole().toString().toLowerCase(Locale.ROOT))));
  }
}
