package com.ds.ds.domain.auth.service;

import com.ds.ds.domain.auth.presentation.data.dto.TokenDto;
import com.ds.ds.domain.auth.exception.UnsupportedJwtTokenException;

public interface TokenReissueService {
    TokenDto reissue(String refreshToken) throws UnsupportedJwtTokenException;
}
