package com.ds.ds.domain.auth.util.Impl;

import com.ds.ds.domain.auth.presentation.dto.SignInDto;
import com.ds.ds.domain.auth.presentation.dto.TokenDto;
import com.ds.ds.domain.auth.presentation.request.SignInRequestDto;
import com.ds.ds.domain.auth.presentation.response.TokenResponseDto;
import com.ds.ds.domain.auth.util.AuthConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthConverterImpl implements AuthConverter {

    @Override
    public SignInDto toDto(SignInRequestDto signInRequestDto) {
        return SignInDto.builder()
                .email(signInRequestDto.getEmail())
                .password(signInRequestDto.getPassword())
                .build();
    }

    @Override
    public TokenResponseDto toResponse(TokenDto tokenDto) {
        return TokenResponseDto.builder()
                .accessToken(tokenDto.getAccessToken())
                .refreshToken(tokenDto.getRefreshToken())
                .accessExp(tokenDto.getAccessExp())
                .refreshExp(tokenDto.getRefreshExp())
                .build();
    }
}
