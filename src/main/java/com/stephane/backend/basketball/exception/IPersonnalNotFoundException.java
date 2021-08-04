package com.stephane.backend.basketball.exception;

import java.io.Serializable;

public interface IPersonnalNotFoundException extends Serializable {
    String getMessage();

    ErrorCode getCode();

    String getId();
}
