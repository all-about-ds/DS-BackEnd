package com.ds.ds.domain.auth.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class DuplicateEmailException extends GlobalException {
    public DuplicateEmailException(ErrorCode errorCode) {
        super(errorCode);
    }
}
