package com.ds.ds.domain.chatting.presentation.data.request;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class CreateChatRequest {
    private Long id;
    private Long chatRoomId;
    private List<Long> members;
}
