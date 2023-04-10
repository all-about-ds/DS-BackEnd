package com.ds.ds.domain.chatting.presentation;

import com.ds.ds.domain.chatting.domain.entity.ChatMessage;
import com.ds.ds.domain.chatting.service.RedisMessageSubscriber;
import com.ds.ds.domain.chatting.service.SendMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final SendMessageService sendMessageService;
    @MessageMapping("/chat.sendMessage")
    @SendTo("/sub/chat/room/{roomId}")
    public ChatMessage sendMessage(@DestinationVariable String roomId, @Payload ChatMessage chatMessage) {
        sendMessageService.sendMessage(chatMessage);
        return chatMessage;
    }

    @GetMapping("/chat/{roomId}")
    public String chatRoom(@PathVariable String roomId, Model model) {
        model.addAttribute("roomId", roomId);
        return "chat-room";
    }
    @GetMapping("/chat/history/{roomId}")
    @ResponseBody
    public ResponseEntity<List<ChatMessage>> getChatHistory(@PathVariable String roomId, @RequestParam("startIndex") Long startIndex, @RequestParam("endIndex") Long endIndex) {
        List<ChatMessage> chatHistory = sendMessageService.getChatHistory(roomId, startIndex, endIndex);
        return ResponseEntity.ok(chatHistory);
        }
    }

