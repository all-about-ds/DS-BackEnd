package com.ds.ds.domain.auth.presentation;

import com.ds.ds.domain.auth.presentation.data.dto.*;
import com.ds.ds.domain.auth.presentation.data.request.SearchPasswordRequest;
import com.ds.ds.domain.auth.presentation.data.request.SignInRequest;
import com.ds.ds.domain.auth.presentation.data.request.SignupRequest;
import com.ds.ds.domain.auth.presentation.data.response.CheckAuthCodeResponse;
import com.ds.ds.domain.auth.presentation.data.response.SendAuthCodeResponse;
import com.ds.ds.domain.auth.presentation.data.response.TokenResponse;
import com.ds.ds.domain.auth.service.*;
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
    private final TokenReissueService tokenReissueService;
    private final SearchPasswordService searchPasswordService;
    private final LogoutService logoutService;

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
    public ResponseEntity<SendAuthCodeResponse> email(@RequestParam("email") String email) throws Exception {
        SendAuthCodeDto sendAuthCodeDto = emailService.sendSimpleMessage(email);
        SendAuthCodeResponse sendAuthCodeResponse = authConverter.toResponse(sendAuthCodeDto);
        return new ResponseEntity<>(sendAuthCodeResponse, HttpStatus.OK);
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

    /*
    담당자: 노혁
    기능: 토큰 재발급
     */
    @PatchMapping
    public ResponseEntity<TokenResponse> tokenReissue(@RequestHeader("RefreshToken") String refreshToken){
        TokenDto tokenDto = tokenReissueService.reissue(refreshToken);
        TokenResponse tokenResponse = authConverter.toResponse(tokenDto);
        return new ResponseEntity<>(tokenResponse, HttpStatus.OK);
    }

    /*
    담당자: 노혁
    기능: 비밀번호 찾기
     */
    @PostMapping("/search")
    public ResponseEntity<Void> searchPassword(@RequestBody SearchPasswordRequest searchPasswordRequest){
        SearchPasswordDto searchPasswordDto = authConverter.toDto(searchPasswordRequest);
        searchPasswordService.search(searchPasswordDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
    담당자: 노혁
    기능: 로그아웃
     */
    @DeleteMapping("/logout")
    public ResponseEntity<Void> logout(@RequestHeader("Authorization") String accessToken) {
        String token = accessToken.replace("Bearer ", "");
        logoutService.logout(token);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
