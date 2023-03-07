package com.ds.ds.domain.chatting.presentation.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatDto {
    public enum MessageType{
        ENTER, TALK, LEAVE;
    }
    private MessageType type;
    private String roomId;
    private String sender; //보낸사람
    private String message;
    private String time; //채팅 발송 시간
}
