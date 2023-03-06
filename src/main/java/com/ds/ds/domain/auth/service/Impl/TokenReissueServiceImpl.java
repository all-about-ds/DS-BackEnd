package com.ds.ds.domain.auth.service.Impl;

import com.ds.ds.domain.auth.domain.entity.RefreshToken;
import com.ds.ds.domain.auth.domain.repository.RefreshTokenRepository;
import com.ds.ds.domain.auth.exception.ExpiredTokenException;
import com.ds.ds.domain.auth.presentation.data.dto.TokenDto;
import com.ds.ds.domain.auth.service.TokenReissueService;
import com.ds.ds.domain.auth.util.AuthConverter;
import com.ds.ds.domain.user.util.UserUtil;
import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TokenReissueServiceImpl implements TokenReissueService {
    private final JwtProvider jwtProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final AuthConverter authConverter;

    @Transactional
    @Override
    public TokenDto reissue(String refreshToken) {
        if(jwtProvider.validateToken(refreshToken)){
            throw new ExpiredTokenException(ErrorCode.EXPIRED_TOKEN);
        }

        String email = jwtProvider.getTokenBody(refreshToken).getSubject();
        RefreshToken existingRefreshToken = refreshTokenRepository.findByToken(refreshToken);

        String newAccessToken = jwtProvider.generateAccessToken(email);
        String newRefreshToken = jwtProvider.generateRefreshToken(email);
        LocalDateTime newAccessExpiredTime = jwtProvider.getAccessTokenExpiredTime();
        LocalDateTime newRefreshExpiredTime = jwtProvider.getRefreshTokenExpiredTime();

        RefreshToken newRefreshTokenEntity =  authConverter.toEntity(existingRefreshToken.getUserId(), newRefreshToken);

        refreshTokenRepository.save(newRefreshTokenEntity);

        return new TokenDto(
                newAccessToken,
                newRefreshToken,
                newAccessExpiredTime,
                newRefreshExpiredTime
        );
    }
}
