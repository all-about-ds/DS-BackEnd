package com.ds.ds.domain.auth.service;

import com.ds.ds.domain.auth.presentation.data.dto.TokenDto;

public interface TokenReissueService {
    TokenDto reissue(String refreshToken);
}
