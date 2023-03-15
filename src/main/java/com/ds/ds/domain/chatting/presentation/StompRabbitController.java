package com.ds.ds.domain.chatting.presentation;

import com.ds.ds.domain.chatting.presentation.data.dto.ChatRoomDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
@Slf4j
@RequiredArgsConstructor
public class StompRabbitController {
    private final RabbitTemplate template;

    private final static String CHAT_EXCHANGE_NAME = "chat.exchange";
    private final static String CHAT_QUEUE_NAME = "chat.queue";

    @MessageMapping("chat.enter.{chatRoomId}")
    public void enter(ChatRoomDto chat, @DestinationVariable String chatRommId){
        chat.setMessage("입장하였습니다");
        chat.setRegDate(LocalDateTime.now());

        template.convertAndSend(CHAT_EXCHANGE_NAME, "room." + chatRommId, chat); // exchange
        //template.convertAndSend("room." + chatRoomId, chat); //queue
        //template.convertAndSend("amq.topic", "room." + chatRoomId, chat); //

    }
    @MessageMapping("chat.message.{chatRoomId}")
    public void send(ChatRoomDto chat, @DestinationVariable String chatRoomid) {
        chat.setRegDate(LocalDateTime.now());

        template.convertAndSend(CHAT_EXCHANGE_NAME, "room." + chatRoomid, chat);
        //template.convertAndSend( "room." + chatRoomId, chat);
        //template.convertAndSend("amq.topic", "room." + chatRoomId, chat);
    }
    @RabbitListener(queues = CHAT_QUEUE_NAME)
    public void receive(ChatRoomDto chat){

        System.out.printf("received : " + chat.getMessage());
    }
}
