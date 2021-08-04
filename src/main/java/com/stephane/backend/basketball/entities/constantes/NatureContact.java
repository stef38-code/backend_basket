package com.stephane.backend.basketball.entities.constantes;

import lombok.Getter;

public enum NatureContact {
    PERSONNEL("PERSO"),
    PROFESSIONEL("PROF");
    @Getter
    private String code;

    private NatureContact(String code) {
        this.code = code;
    }
}
