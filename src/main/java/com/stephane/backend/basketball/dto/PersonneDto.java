package com.stephane.backend.basketball.dto;

import com.stephane.backend.basketball.entities.constantes.Categorie;
import com.stephane.backend.basketball.entities.constantes.Genre;
import com.stephane.backend.basketball.entities.constantes.Role;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
// @Relation(value = "personne", collectionRelation = "personnes")
public class PersonneDto extends RepresentationModel<PersonneDto> {
  private String nom;
  private String prenom;
  private LocalDate datenaiss;
  private Genre genre;
  private Categorie categorie;
  private Role role;
}
