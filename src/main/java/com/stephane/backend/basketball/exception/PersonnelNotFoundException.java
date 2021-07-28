package com.stephane.backend.basketball.exception;

import lombok.Getter;

public class PersonnelNotFoundException extends RuntimeException implements IPersonnalNotFoundException {
    private static final long serialVersionUID = -6833775001657120109L;
    @Getter
    private final ErrorCode code;
    @Getter
    private final String id;
    protected String detailMessage;


    public PersonnelNotFoundException(ErrorCode code, String id) {
        super();
        this.code = code;
        this.id = id;
    }

    @Override
    public String getMessage() {
        return String.format(detailMessage, id);
    }
}
