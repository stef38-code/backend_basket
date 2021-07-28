package com.stephane.backend.basketball.services;

import com.stephane.backend.basketball.dto.PersonneDto;
import com.stephane.backend.basketball.entities.Personne;
import com.stephane.backend.basketball.exception.ErrorCode;
import com.stephane.backend.basketball.exception.PersonneNotFoundException;
import com.stephane.backend.basketball.mapper.PersonneMapper;
import com.stephane.backend.basketball.repository.PersonneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonneService {
    private final PersonneRepository repository;
    private final PersonneMapper mapper;

    public PersonneDto getPersonneDetails(String personneId) {
        Optional<Personne> byId = repository.findById(personneId);
        if (byId.isPresent()) {
            PersonneDto personneDto = mapper.toPersonneDto(byId.get());
            return personneDto;
        }
        throw new PersonneNotFoundException(ErrorCode.APPLICATIF, personneId);
    }

    public Collection<PersonneDto> getAllPersonnes() {
        List<Personne> all = repository.findAll();
        return null;
    }
}
