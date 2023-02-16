package com.ds.ds.domain.auth.util;

import com.ds.ds.domain.auth.presentation.dto.SignInDto;
import com.ds.ds.domain.auth.presentation.dto.TokenDto;
import com.ds.ds.domain.auth.presentation.request.SignInRequestDto;
import com.ds.ds.domain.auth.presentation.response.TokenResponse;

public interface AuthConverter {
    SignInDto toDto(SignInRequestDto signInRequestDto);

    TokenResponse toResponse(TokenDto tokenDto);
}
