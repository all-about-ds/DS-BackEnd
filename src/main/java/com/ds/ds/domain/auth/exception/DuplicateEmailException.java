package com.ds.ds.domain.auth.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;

public class DuplicateEmailException extends GlobalException {
    public DuplicateEmailException(ErrorCode errorCode) {
        super(errorCode);
    }
}
