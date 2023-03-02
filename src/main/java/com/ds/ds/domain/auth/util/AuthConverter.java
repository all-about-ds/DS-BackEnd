package com.ds.ds.domain.auth.util;

import com.ds.ds.domain.auth.domain.entity.AuthCode;
import com.ds.ds.domain.auth.domain.entity.RefreshToken;
import com.ds.ds.domain.auth.presentation.data.dto.SignInDto;
import com.ds.ds.domain.auth.presentation.data.dto.SignUpDto;
import com.ds.ds.domain.auth.presentation.data.dto.TokenDto;
import com.ds.ds.domain.auth.presentation.data.request.SignInRequest;
import com.ds.ds.domain.auth.presentation.data.request.SignupRequest;
import com.ds.ds.domain.auth.presentation.data.response.TokenResponse;
import com.ds.ds.domain.user.domain.entity.User;


public interface AuthConverter {
    SignInDto toDto(SignInRequest signInRequest);
    SignUpDto toDto(SignupRequest signupRequest);
    TokenResponse toResponse(TokenDto tokenDto);
    RefreshToken toEntity(User user, String refreshToken);
    User toEntity(SignUpDto signUpDto);
    AuthCode toEntity(String email, String code);
}
