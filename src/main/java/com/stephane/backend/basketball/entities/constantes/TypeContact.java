package com.stephane.backend.basketball.entities.constantes;

import lombok.Getter;

public enum TypeContact {
    EMAIL("E"),
    TEL_PORTABLE("TP"),
    TEL_FIXE("TF");
    @Getter
    private String code;

    private TypeContact(String code) {
        this.code = code;
    }
}
