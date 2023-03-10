package com.ds.ds.domain.auth.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.mail.internet.MimeMessage;

@Getter
@Builder
@RequiredArgsConstructor
public class CreateMessageDto {
    private final MimeMessage message;
    private final String code;
}
