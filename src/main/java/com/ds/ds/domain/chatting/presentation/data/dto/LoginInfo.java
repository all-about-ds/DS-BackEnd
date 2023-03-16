package com.ds.ds.domain.chatting.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class LoginInfo {
    private final String name;

    @Builder
    public LoginInfo(String name) {
        this.name = name;
    }
}

