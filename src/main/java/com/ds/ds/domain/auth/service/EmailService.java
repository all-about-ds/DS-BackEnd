package com.ds.ds.domain.auth.service;

import com.ds.ds.domain.auth.presentation.data.dto.CheckAuthCodeDto;

public interface EmailService {
    void sendSimpleMessage(String email) throws Exception;

    CheckAuthCodeDto checkAuthCode(String code);
}
