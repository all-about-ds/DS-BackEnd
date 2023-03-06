package com.ds.ds.domain.user.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;
import lombok.Getter;

@Getter
public class UserNotFoundException extends GlobalException {

    public UserNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
