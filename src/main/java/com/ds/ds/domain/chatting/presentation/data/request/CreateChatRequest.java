package com.ds.ds.domain.chatting.presentation.data.request;


import com.ds.ds.domain.chatting.presentation.data.dto.ChatDto;
import com.ds.ds.domain.member.domain.entity.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class CreateChatRequest {
    private Long id;
    private Long chatRoomId;
    private List<ChatDto> messages;
    private List<Member> members;
}
