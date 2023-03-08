package com.ds.ds.domain.group.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;

public class UserNotMemberException extends GlobalException {

    public UserNotMemberException(ErrorCode errorCode) {
        super(errorCode);
    }
}
