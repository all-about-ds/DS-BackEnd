package com.ds.ds.domain.chatting.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class LoginInfo {
    private final String name;
    private final String token;

    @Builder
    public LoginInfo(String name, String token) {
        this.name = name;
        this.token = token;
    }
}
