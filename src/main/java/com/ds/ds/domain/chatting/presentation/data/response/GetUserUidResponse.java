package com.ds.ds.domain.chatting.presentation.data.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class GetUserUidResponse {
    private final Long uid;
}
