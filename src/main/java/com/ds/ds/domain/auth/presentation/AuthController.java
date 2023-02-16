package com.ds.ds.domain.auth.presentation;

import com.ds.ds.domain.auth.presentation.dto.SignInDto;
import com.ds.ds.domain.auth.presentation.request.SignInRequestDto;
import com.ds.ds.domain.auth.presentation.response.TokenResponse;
import com.ds.ds.domain.auth.service.SignInService;
import com.ds.ds.domain.auth.util.AuthConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthConverter authConverter;
    private final SignInService signinService;

    /*
    담당자: 노혁
    기능: 로그인
     */
    @PostMapping("/signin")
    public ResponseEntity<TokenResponse> signIn(@RequestBody SignInRequestDto signInRequestDto){
        SignInDto signInDto = authConverter.toDto(signInRequestDto);
        TokenResponse tokenResponse = signinService.signIn(signInDto);
        return new ResponseEntity<>(tokenResponse, HttpStatus.OK);
    }
}
