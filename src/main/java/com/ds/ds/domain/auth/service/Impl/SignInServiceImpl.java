package com.ds.ds.domain.auth.service.Impl;

import com.ds.ds.domain.auth.domain.entity.RefreshToken;
import com.ds.ds.domain.auth.domain.repository.RefreshTokenRepository;
import com.ds.ds.domain.auth.presentation.data.dto.SignInDto;
import com.ds.ds.domain.auth.presentation.data.dto.TokenDto;
import com.ds.ds.domain.auth.service.SignInService;
import com.ds.ds.domain.auth.util.AuthConverter;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.util.UserUtil;
import com.ds.ds.global.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SignInServiceImpl implements SignInService {
    private final AuthConverter authConverter;
    private final UserUtil userUtil;
    private final JwtProvider jwtProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    public TokenDto signIn(SignInDto signInDto) {
        User user = userUtil.findUserByEmail(signInDto.getEmail());
        userUtil.checkPassword(user.getPassword(), signInDto.getPassword());

        String accessToken = jwtProvider.generateAccessToken(user.getEmail());
        String refreshToken = jwtProvider.generateRefreshToken(user.getEmail());
        LocalDateTime accessExpiredTime = jwtProvider.getAccessTokenExpiredTime();
        LocalDateTime refreshExpiredTime = jwtProvider.getRefreshTokenExpiredTime();

        RefreshToken refresh = authConverter.toEntity(user, refreshToken);
        refreshTokenRepository.save(refresh);

        return new TokenDto(
                accessToken,
                refreshToken,
                accessExpiredTime,
                refreshExpiredTime
        );
    }
}
