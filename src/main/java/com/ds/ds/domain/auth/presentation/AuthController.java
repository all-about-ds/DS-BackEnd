package com.ds.ds.domain.auth.presentation;

import com.ds.ds.domain.auth.presentation.data.dto.*;
import com.ds.ds.domain.auth.presentation.data.request.SignInRequest;
import com.ds.ds.domain.auth.presentation.data.request.SignupRequest;
import com.ds.ds.domain.auth.presentation.data.response.CheckAuthCodeResponse;
import com.ds.ds.domain.auth.presentation.data.response.TokenResponse;
import com.ds.ds.domain.auth.service.EmailService;
import com.ds.ds.domain.auth.service.SignInService;
import com.ds.ds.domain.auth.service.SignUpService;
import com.ds.ds.domain.auth.util.AuthConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthConverter authConverter;
    private final SignInService signinService;
    private final SignUpService signUpService;
    private final EmailService emailService;

    /*
    담당자: 노혁
    기능: 로그인
     */
    @PostMapping("/signin")
    public ResponseEntity<TokenResponse> signIn(@RequestBody SignInRequest signInRequest){
        SignInDto signInDto = authConverter.toDto(signInRequest);
        TokenDto tokenDto = signinService.signIn(signInDto);
        TokenResponse tokenResponse = authConverter.toResponse(tokenDto);
        return new ResponseEntity<>(tokenResponse, HttpStatus.OK);
    }

    /*
    담당자: 노혁
    기능: 회원가입
     */
    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@RequestBody @Valid SignupRequest signupRequest){
        SignUpDto signUpDto = authConverter.toDto(signupRequest);
        signUpService.signUp(signUpDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /*
    담당자: 노혁
    기능: 인증번호 전송
     */
    @PostMapping("/email")
    public ResponseEntity<Void> email(@RequestParam("email") String email) throws Exception {
        emailService.sendSimpleMessage(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
    담당자: 노혁
    기능: 인증번호 확인
     */
    @GetMapping("/code")
    public ResponseEntity<CheckAuthCodeResponse> code(@RequestParam("code") String code){
        CheckAuthCodeDto checkAuthCodeDto = emailService.checkAuthCode(code);
        CheckAuthCodeResponse checkAuthCodeResponse = authConverter.toResponse(checkAuthCodeDto);
        return new ResponseEntity<>(checkAuthCodeResponse, HttpStatus.OK);
    }


}
