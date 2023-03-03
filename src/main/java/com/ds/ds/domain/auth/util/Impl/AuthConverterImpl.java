package com.ds.ds.domain.auth.util.Impl;

import com.ds.ds.domain.auth.domain.entity.AuthCode;
import com.ds.ds.domain.auth.domain.entity.RefreshToken;
import com.ds.ds.domain.auth.presentation.data.dto.*;
import com.ds.ds.domain.auth.presentation.data.request.SignInRequest;
import com.ds.ds.domain.auth.presentation.data.request.SignupRequest;
import com.ds.ds.domain.auth.presentation.data.response.CheckAuthCodeResponse;
import com.ds.ds.domain.auth.presentation.data.response.TokenResponse;
import com.ds.ds.domain.auth.util.AuthConverter;
import com.ds.ds.domain.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class AuthConverterImpl implements AuthConverter {
    private final PasswordEncoder passwordEncoder;

    @Override
    public SignInDto toDto(SignInRequest signInRequest) {
        return SignInDto.builder()
                .email(signInRequest.getEmail())
                .password(signInRequest.getPassword())
                .build();
    }

    @Override
    public SignUpDto toDto(SignupRequest signupRequest) {
        return SignUpDto.builder()
                .name(signupRequest.getName())
                .email(signupRequest.getEmail())
                .password(signupRequest.getPassword())
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

    @Override
    public User toEntity(SignUpDto signUpDto){
        return User.builder()
                .name(signUpDto.getName())
                .email(signUpDto.getEmail())
                .password(passwordEncoder.encode(signUpDto.getPassword()))
                .build();
    }

    @Override
    public AuthCode toEntity(String email, String code) {
        return AuthCode.builder()
                .email(email)
                .code(code)
                .build();
    }

    @Override
    public CheckAuthCodeDto toDto(String email) {
        return CheckAuthCodeDto.builder()
                .email(email)
                .build();
    }

    @Override
    public CheckAuthCodeResponse toResponse(CheckAuthCodeDto checkAuthCodeDto) {
        return CheckAuthCodeResponse.builder()
                .email(checkAuthCodeDto.getEmail())
                .build();
    }
}
