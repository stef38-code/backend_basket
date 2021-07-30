package com.stephane.backend.basketball.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "adresse")
public class Adresse extends AbstractEntityBase<String> {

  @Column(name = "adr_lig1")
  private String ligne1;

  @Column(name = "adr_lig2")
  private String ligne2;

  @Column(name = "adr_lig3")
  private String ligne3;

  @Column(name = "adr_lig4")
  private String ligne4;

  @Column(name = "adr_cp")
  private String codePostal;

  @Column(name = "adr_commune")
  private String commune;

  @Column(name = "adr_pays")
  private String pays;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToMany(mappedBy = "adresses", fetch = FetchType.EAGER)
  private Set<Personne> famille = new HashSet<>();
}
