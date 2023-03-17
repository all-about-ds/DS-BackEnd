package com.ds.ds.domain.auth.service.Impl;

import com.ds.ds.domain.auth.domain.repository.RefreshTokenRepository;
import com.ds.ds.domain.auth.service.LogoutService;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.util.UserUtil;
import com.ds.ds.global.redis.util.RedisUtil;
import com.ds.ds.global.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogoutServiceImpl implements LogoutService {
    private final JwtProvider jwtProvider;
    private final RedisUtil redisUtil;
    private final UserUtil userUtil;
    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    public void logout(String accessToken) {
        jwtProvider.validateToken(accessToken);

        User user = userUtil.currentUser();
        refreshTokenRepository.deleteById(user.getIdx());

        Long expiration = jwtProvider.getExpiration(accessToken);
        redisUtil.setBlackList(accessToken, "access_token", expiration);
    }
}
