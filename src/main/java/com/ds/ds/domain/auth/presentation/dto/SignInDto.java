package com.ds.ds.domain.auth.presentation.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class SignInDto {
    private final String email;
    private final String password;
}
