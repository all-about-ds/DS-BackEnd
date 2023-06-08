package com.ds.ds.domain.auth.presentation.data.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UpdatePasswordRequest {
    private final String email;
    private final String password;
}
