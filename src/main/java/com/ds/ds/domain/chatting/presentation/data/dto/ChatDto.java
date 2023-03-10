package com.ds.ds.domain.chatting.presentation.data.dto;

import lombok.*;

@Getter
@Builder
@Setter
@RequiredArgsConstructor
public class ChatDto {
    public void setMessage(String s) {
    }

    public enum MessageType{
        ENTER, TALK, LEAVE;
    }
    private final MessageType type;
    private final String roomId;
    private final String writer; //보낸사람
    private final String message;
    private final String time; //채팅 발송 시간
}
