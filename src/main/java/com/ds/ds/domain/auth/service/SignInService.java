package com.ds.ds.domain.auth.service;

import com.ds.ds.domain.auth.presentation.data.dto.SignInDto;
import com.ds.ds.domain.auth.presentation.data.dto.TokenDto;

public interface SignInService {
    TokenDto signIn(SignInDto signInDto);
}
