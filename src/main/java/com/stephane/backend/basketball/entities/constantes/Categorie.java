package com.stephane.backend.basketball.entities.constantes;

import lombok.Getter;

public enum Categorie {
    U7("U7"),
    U9("U9"),
    U11("U11"),
    U13("U13"),
    U15("U15"),
    U17("U17"),
    U18("U18"),
    SENIOR("SENIOR");
    @Getter
    private String code;

    private Categorie(String code) {
        this.code = code;
    }
}
