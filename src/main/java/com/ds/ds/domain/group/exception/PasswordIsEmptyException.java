package com.ds.ds.domain.group.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;

public class PasswordIsEmptyException extends GlobalException {
    public PasswordIsEmptyException(ErrorCode errorCode) {
        super(errorCode);
    }
}
