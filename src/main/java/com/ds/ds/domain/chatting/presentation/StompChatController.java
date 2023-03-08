package com.ds.ds.domain.chatting.presentation;

import com.ds.ds.domain.chatting.presentation.data.dto.ChatDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class StompChatController {
    private final SimpMessagingTemplate template; //특정 Broker로 메세지를 전달
    //클라이언트가 Send할 수 있는 경로
    @MessageMapping(value = "/chat/enter")
    public void enter(ChatDto message){
        message.seta(message.getWriter() + "님이 채팅방에 참여하였습니다");
        template.convertAndSend("sub/chat/room/" + message.getRoomId(), message);

    }
}
