package com.stephane.backend.basketball.dto;

import com.stephane.backend.basketball.entities.constantes.NatureContact;
import com.stephane.backend.basketball.entities.constantes.TypeContact;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "Contacts")
public class ContactDto extends RepresentationModel<ContactDto> {
  private TypeContact typecontact;
  private NatureContact naturecontact;
  private String valeur;
}
