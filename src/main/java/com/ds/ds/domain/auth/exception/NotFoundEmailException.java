package com.ds.ds.domain.auth.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;

public class NotFoundEmailException extends GlobalException {
    public NotFoundEmailException(ErrorCode errorCode) {
        super(errorCode);
    }
}
