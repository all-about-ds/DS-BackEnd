package com.ds.ds.domain.auth.service;

import com.ds.ds.domain.auth.presentation.dto.SignInDto;
import com.ds.ds.domain.auth.presentation.response.TokenResponseDto;

public interface SignInService {
    TokenResponseDto signIn(SignInDto signInDto);
}
