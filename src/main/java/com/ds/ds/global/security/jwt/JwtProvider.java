package com.ds.ds.global.security.jwt;

import com.ds.ds.domain.auth.exception.ExpiredTokenException;
import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.security.auth.AuthDetailsService;
import com.ds.ds.domain.auth.exception.IllegalArgumentJwtTokenException;
import com.ds.ds.domain.auth.exception.InvalidJwtSignatureException;
import com.ds.ds.domain.auth.exception.UnsupportedJwtTokenException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtProvider {
    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;
    private final long ACCESS_TOKEN_EXPIRED_TIME = 60L * 15;
    private final long REFRESH_TOKEN_EXPIRED_TIME = 60L * 60 * 24 * 7; // 1주
    private TokenType tokenType;

    @AllArgsConstructor
    public enum TokenType{
        ACCESS_TOKEN("accessToken"),
        REFRESH_TOKEN("refreshToken");

        private final String value;
    }
    public String generateAccessToken(String email){
        return createToken(email,TokenType.ACCESS_TOKEN);
    }

    public String generateRefreshToken(String email){
        return createToken(email,TokenType.REFRESH_TOKEN);
    }

    public LocalDateTime getAccessTokenExpiredTime(){
        return LocalDateTime.now().plusSeconds(ACCESS_TOKEN_EXPIRED_TIME);
    }

    public LocalDateTime getRefreshTokenExpiredTime(){
        return LocalDateTime.now().plusSeconds(REFRESH_TOKEN_EXPIRED_TIME);
    }

    public Authentication getAuthentication(String token){
        UserDetails userDetails = authDetailsService.loadUserByUsername(getTokenSubject(token, TokenType.ACCESS_TOKEN));
        return new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities());
    }

    public String resolveToken(HttpServletRequest servletRequest){
        String token = servletRequest.getHeader("Authorization");
        if((token != null) && token.startsWith("Bearer ")){
            return token.replace("Bearer ","");
        }
        return null;
    }

    public void validateToken(String token) throws InvalidJwtSignatureException, UnsupportedJwtTokenException {
        try{
            getTokenBody(token, tokenType);
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            throw new InvalidJwtSignatureException(ErrorCode.INVALID_JWT_SIGNATURE);
        } catch (ExpiredJwtException e) {
            throw new ExpiredTokenException(ErrorCode.EXPIRED_TOKEN);
        } catch (UnsupportedJwtException e) {
            throw new UnsupportedJwtTokenException(ErrorCode.UNSUPPORTED_JWT);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentJwtTokenException(ErrorCode.ILLEGAL_ARGUMENT_JWT);
        }
    }

    public String getTokenSubject(String token, TokenType tokenType){
        return getTokenBody(token, tokenType).getSubject();
    }

    public Long getExpiration(String accessToken) {
        Date expiration = getTokenBody(accessToken, TokenType.ACCESS_TOKEN).getExpiration();
        long now = new Date().getTime();
        return (expiration.getTime() - now);
    }

    private Claims getTokenBody(String token, TokenType tokenType){
        return Jwts.parserBuilder()
                .setSigningKey(getKeyByTokenType(tokenType))
                .build()
                .parseClaimsJws(token)
                .getBody();

    }

    private Key getByteKey(String key){
        byte[] keyByte = key.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyByte);
    }

    private String createToken(String email,TokenType tokenType){
        return Jwts.builder()
                .signWith(getKeyByTokenType(tokenType),SignatureAlgorithm.HS256)
                .claim("email",email)
                .claim("type",tokenType)
                .setIssuedAt(new Date())
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + getTokenExpiredTime(tokenType) * 1000))
                .compact();
    }
    public String generateToken(String name) {
        Date now = new Date();
        return Jwts.builder()
                .setId(name)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + ACCESS_TOKEN_EXPIRED_TIME))
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getAccessSecret())
                .compact();
    }

    private Key getKeyByTokenType(TokenType tokenType){
        if(tokenType == TokenType.ACCESS_TOKEN){
            return getByteKey(jwtProperties.getAccessSecret());
        }
        else{
            return getByteKey(jwtProperties.getRefreshSecret());
        }
    }

    private long getTokenExpiredTime(TokenType tokenType){
        if(tokenType == TokenType.ACCESS_TOKEN){
            return ACCESS_TOKEN_EXPIRED_TIME;
        }
        else{
            return REFRESH_TOKEN_EXPIRED_TIME;
        }
    }
}
