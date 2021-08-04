package com.stephane.backend.basketball.exception;

public class ContactNotFoundException extends PersonnelNotFoundException {
  public ContactNotFoundException(ErrorCode code, String id) {
    super(code, id);
    detailMessage = "le contact avec l'ID %s est introuvable";
  }
}
