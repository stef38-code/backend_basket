package com.stephane.backend.basketball.exception;

public class PersonneNotFoundException extends PersonnelNotFoundException {
    public PersonneNotFoundException(ErrorCode code, String id) {
        super(code, id);
        detailMessage = "la personne avec l'ID %s est introuvable";
    }
}
