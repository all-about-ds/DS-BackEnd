package com.ds.ds.domain.auth.util.Impl;

import com.ds.ds.domain.auth.domain.entity.RefreshToken;
import com.ds.ds.domain.auth.presentation.data.dto.SignInDto;
import com.ds.ds.domain.auth.presentation.data.dto.TokenDto;
import com.ds.ds.domain.auth.presentation.data.request.SignInRequest;
import com.ds.ds.domain.auth.presentation.data.response.TokenResponse;
import com.ds.ds.domain.auth.util.AuthConverter;
import com.ds.ds.domain.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class AuthConverterImpl implements AuthConverter {

    @Override
    public SignInDto toDto(SignInRequest signInRequest) {
        return SignInDto.builder()
                .email(signInRequest.getEmail())
                .password(signInRequest.getPassword())
                .build();
    }

    @Override
    public TokenResponse toResponse(TokenDto tokenDto) {
        return TokenResponse.builder()
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
