package com.ds.ds.global.security.jwt;

import antlr.Token;
import com.ds.ds.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtProvider {
    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;
    private final long ACCESS_TOKEN_EXPIRED_TIME = 2 * 60 * 1000;
    private final long REFRESH_TOKEN_EXPIRED_TIME = 7 * 24 * 60 * 60 * 1000; // 1주

    @AllArgsConstructor
    enum TokenType{
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
    public Authentication getAuthentication(String token){
        UserDetails userDetails = authDetailsService.loadUserByUsername(getTokenSubject(token, jwtProperties.getAccessSecret()));
        return new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities());
    }
    public String resolveToken(HttpServletRequest servletRequest){
        String token = servletRequest.getHeader("Authorization");
        if((token != null) && token.startsWith("Bearer ")){
            return token.replace("Bearer ","");
        }
        return null;
    }
    private String getTokenSubject(String token, String secret){
        return getTokenBody(token,secret).getSubject();
    }
    private Claims getTokenBody(String token, String secret){
        return Jwts.parserBuilder()
                .setSigningKey(getByteKey(jwtProperties.getAccessSecret()))
                .build()
                .parseClaimsJwt(token)
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
