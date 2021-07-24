package com.stephane.backend.basketball.entities.constantes;

import lombok.Getter;

public enum Role {
    PERE("P"), MERE("M"), ENFANT("E");
    @Getter
    private String code;

    private Role(String code) {
        this.code = code;
    }
}
