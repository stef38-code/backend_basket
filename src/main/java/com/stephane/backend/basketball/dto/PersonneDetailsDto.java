package com.stephane.backend.basketball.dto;

import com.stephane.backend.basketball.entities.ActiviteDansLeClub;
import com.stephane.backend.basketball.entities.constantes.Categorie;
import com.stephane.backend.basketball.entities.constantes.Genre;
import com.stephane.backend.basketball.entities.constantes.Role;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PersonneDetailsDto extends RepresentationModel<PersonneDetailsDto> {
  private String nom;
  private String prenom;
  private LocalDate datenaiss;
  private Genre genre;
  private Role role;
  private Categorie categorie;
  private ActiviteDansLeClub activiteDansLeClub;
  private Set<PersonneDto> famille = new HashSet<>();
  private Set<AdresseDto> adresses = new HashSet<>();
  private Set<ContactDto> contacts = new HashSet<>();
}
