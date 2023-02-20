package com.ds.ds.domain.auth.util.Impl;

import com.ds.ds.domain.auth.domain.entity.RefreshToken;
import com.ds.ds.domain.auth.presentation.data.dto.SignInDto;
import com.ds.ds.domain.auth.presentation.data.dto.TokenDto;
import com.ds.ds.domain.auth.presentation.data.request.SignInRequestDto;
import com.ds.ds.domain.auth.presentation.data.response.TokenResponseDto;
import com.ds.ds.domain.auth.util.AuthConverter;
import com.ds.ds.domain.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

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



    @Override
    public RefreshToken toEntity(User user, String refreshToken) {
        return RefreshToken.builder()
                .userId(user.getIdx())
                .token(refreshToken)
                .build();
    }
}
