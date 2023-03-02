package com.ds.ds.domain.auth.presentation.data.request;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class SignInRequest {
    private final String email;
    private final String password;
}
