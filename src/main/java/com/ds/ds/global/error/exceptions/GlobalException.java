package com.ds.ds.global.error.exceptions;

import com.ds.ds.global.error.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GlobalException extends RuntimeException {
    private ErrorCode errorCode;
}
