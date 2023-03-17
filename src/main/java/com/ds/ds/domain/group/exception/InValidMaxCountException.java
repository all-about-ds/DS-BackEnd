package com.ds.ds.domain.group.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;

public class InValidMaxCountException extends GlobalException {
    public InValidMaxCountException(ErrorCode errorCode) {
        super(errorCode);
    }
}
