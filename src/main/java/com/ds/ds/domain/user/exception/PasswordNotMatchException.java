package com.ds.ds.domain.user.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PasswordNotMatchException extends GlobalException {
    private final ErrorCode errorCode;
}
