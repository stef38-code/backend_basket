package com.stephane.backend.basketball.exception;

public class AdresseNotFoundException extends PersonnelNotFoundException {
  public AdresseNotFoundException(ErrorCode code, String id) {
    super(code, id);
    detailMessage = "l'adresse' avec l'ID %s est introuvable";
  }
}
