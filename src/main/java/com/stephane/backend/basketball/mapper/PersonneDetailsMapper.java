package com.stephane.backend.basketball.mapper;

import com.stephane.backend.basketball.controller.PersonneController;
import com.stephane.backend.basketball.dto.PersonneDetailsDto;
import com.stephane.backend.basketball.entities.Personne;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@Mapper(componentModel = "spring",uses = {ContactMapper.class,AdresseMapper.class,PersonneMapper.class})
public interface PersonneDetailsMapper extends ResourceMapper<Personne, PersonneDetailsDto> {

    PersonneDetailsDto map(Personne personne);

  @AfterMapping
  default void addLinks(@MappingTarget PersonneDetailsDto resource, Personne entity) {
    resource.add(
        WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(PersonneController.class)
                    .getPersonneById(entity.getId()))
            .withSelfRel());
    }
}
