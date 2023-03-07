package com.ds.ds.domain.auth.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;

public class BlackListAlreadyExistException extends GlobalException {
    public BlackListAlreadyExistException(ErrorCode errorCode) {
        super(errorCode);
    }
}
