package com.stephane.backend.basketball.dto;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "adresses")
public class AdresseDto extends RepresentationModel<AdresseDto> {
  private String ligne1;
  private String ligne2;
  private String ligne3;
  private String ligne4;
  private String codePostal;
  private String commune;
  private String pays;
}
