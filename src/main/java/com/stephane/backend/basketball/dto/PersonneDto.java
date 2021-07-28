package com.stephane.backend.basketball.dto;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonneDto extends RepresentationModel<PersonneDto> {
    private String nom;
    private String prenom;
    private LocalDate datenaiss;
}
