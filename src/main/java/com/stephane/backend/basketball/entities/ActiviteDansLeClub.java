package com.stephane.backend.basketball.entities;

import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder
@Embeddable
public class ActiviteDansLeClub {

  private boolean joueur;

  private boolean arbitre;

  private boolean dirigeant;

  private boolean entraineur;
}
