package com.ds.ds.global.security.filter;

import com.ds.ds.domain.auth.exception.BlackListAlreadyExistException;
import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final JwtProvider jwtProvider;
    private final RedisTemplate redisTemplate;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        String token = jwtProvider.resolveToken(request);
        if(token != null ){
            Authentication authentication = jwtProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            if(redisTemplate.opsForValue().get(token) != null)
                throw new BlackListAlreadyExistException(ErrorCode.BLACKLIST_ALREADY_EXIST);
        }
        filterChain.doFilter(request,response);
    }
}
