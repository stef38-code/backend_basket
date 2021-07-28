package com.stephane.backend.basketball.mapper;

import com.stephane.backend.basketball.dto.PersonneDto;
import com.stephane.backend.basketball.entities.Personne;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonneMapper {
    PersonneDto toPersonneDto(Personne personne);
}
