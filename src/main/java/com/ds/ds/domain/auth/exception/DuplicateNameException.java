package com.ds.ds.domain.auth.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;

public class DuplicateNameException extends GlobalException {
    public DuplicateNameException(ErrorCode errorCode) {
        super(errorCode);
    }
}
