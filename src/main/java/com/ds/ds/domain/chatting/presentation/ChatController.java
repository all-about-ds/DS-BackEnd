package com.ds.ds.domain.chatting.presentation;

import com.ds.ds.domain.chatting.presentation.data.dto.ChatMessageDto;
import com.ds.ds.domain.chatting.domain.entity.ChatRoom;
import com.ds.ds.domain.chatting.domain.repository.ChatRoomRepository;
import com.ds.ds.domain.chatting.presentation.data.request.ChatRequest;
import com.ds.ds.domain.chatting.service.SendMessageService;
import com.ds.ds.domain.chatting.util.ChatConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final SendMessageService sendMessageService;


    @MessageMapping("/chat.sendMessage")
    @SendTo("/sub/chat/room/{roomId}")
    public ChatMessageDto sendMessage(@DestinationVariable String roomId, @Payload ChatRequest chatRequest) {
        return sendMessageService.sendMessage(roomId, chatRequest);
    }

    @GetMapping("/chat/history/{roomId}")
    @ResponseBody
    public ResponseEntity<List<ChatMessageDto>> getChatHistory(@PathVariable String roomId, @RequestParam("startIndex") Long startIndex, @RequestParam("endIndex") Long endIndex) {
        List<ChatMessageDto> chatHistory = sendMessageService.getChatHistory(roomId, startIndex, endIndex);
        return ResponseEntity.ok(chatHistory);
        }
    }

