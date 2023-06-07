package com.ds.ds.domain.group.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;

public class DuplicateGroupNameException extends GlobalException {
    public DuplicateGroupNameException(ErrorCode errorCode) {
        super(errorCode);
    }
}
