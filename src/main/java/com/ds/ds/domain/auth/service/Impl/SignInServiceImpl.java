package com.ds.ds.domain.auth.service.Impl;

import com.ds.ds.domain.auth.presentation.dto.SignInDto;
import com.ds.ds.domain.auth.presentation.dto.TokenDto;
import com.ds.ds.domain.auth.presentation.response.TokenResponseDto;
import com.ds.ds.domain.auth.service.SignInService;
import com.ds.ds.domain.auth.util.AuthConverter;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.util.UserUtil;
import com.ds.ds.global.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SignInServiceImpl implements SignInService {
    private final AuthConverter authConverter;
    private final UserUtil userUtil;
    private final JwtProvider jwtProvider;
    private final RedisTemplate<String, Object> redisTemplate;


    @Override
    public TokenResponseDto signIn(SignInDto signInDto) {
        User user = userUtil.findUserByEmail(signInDto.getEmail());
        userUtil.checkPassword(user.getPassword(), signInDto.getPassword());

        TokenDto tokenDto = makeTokenDto(user);

        redisTemplate.opsForValue()
                .set("refreshToken:" + user.getIdx(), tokenDto.getRefreshToken());

        return authConverter.toResponse(tokenDto);
    }

    private TokenDto makeTokenDto(User user){
        String accessToken = jwtProvider.generateAccessToken(user.getEmail());
        String refreshToken = jwtProvider.generateRefreshToken(user.getEmail());
        LocalDateTime accessExpiredTime = jwtProvider.getAccessTokenExpiredTime();
        LocalDateTime refreshExpiredTime = jwtProvider.getRefreshTokenExpiredTime();

        return TokenDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .accessExp(accessExpiredTime)
                .refreshExp(refreshExpiredTime)
                .build();
    }
}
