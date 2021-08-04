package com.stephane.backend.basketball.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.stephane.backend.basketball.entities.constantes.NatureContact;
import com.stephane.backend.basketball.entities.constantes.TypeContact;
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
@Table(name = "contact")
public class Contact extends AbstractEntityBase<String> {

  @Column(name = "typecontact")
  private TypeContact typecontact;

  @Column(name = "naturecontact")
  private NatureContact naturecontact;

  @Column(name = "value")
  private String valeur;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @Builder.Default
  @ManyToMany(mappedBy = "contacts", fetch = FetchType.EAGER)
  @JsonBackReference
  private Set<Personne> famille = new HashSet<>();
}
