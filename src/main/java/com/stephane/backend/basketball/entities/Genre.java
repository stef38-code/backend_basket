package com.stephane.backend.basketball.entities;

import lombok.Getter;

public enum Genre {
    MASCULIN("M"), FEMININ("F");
    @Getter
    private String code;

    private Genre(String code) {
        this.code = code;
    }
}
