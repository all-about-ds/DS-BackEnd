package com.ds.ds.domain.user.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;

public class PasswordNotMatchException extends GlobalException {

    public PasswordNotMatchException(ErrorCode errorCode) {
        super(errorCode);
    }
}
