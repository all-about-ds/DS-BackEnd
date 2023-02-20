package com.ds.ds.domain.auth.util;

import com.ds.ds.domain.auth.domain.entity.RefreshToken;
import com.ds.ds.domain.auth.presentation.data.dto.SignInDto;
import com.ds.ds.domain.auth.presentation.data.dto.TokenDto;
import com.ds.ds.domain.auth.presentation.data.request.SignInRequestDto;
import com.ds.ds.domain.auth.presentation.data.response.TokenResponseDto;
import com.ds.ds.domain.user.domain.entity.User;

import java.time.LocalDateTime;

public interface AuthConverter {
    SignInDto toDto(SignInRequestDto signInRequestDto);

    TokenResponseDto toResponse(TokenDto tokenDto);

    RefreshToken toEntity(User user, String refreshToken);
}
