package com.ds.ds.domain.auth.service;

import com.ds.ds.domain.auth.presentation.data.dto.CheckAuthCodeDto;
import com.ds.ds.domain.auth.presentation.data.dto.SendAuthCodeDto;

public interface EmailService {
    SendAuthCodeDto sendSimpleMessage(String email) throws Exception;

    CheckAuthCodeDto checkAuthCode(String code, String email);
}
