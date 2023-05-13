package com.ds.ds.domain.chatting.presentation;

import com.ds.ds.domain.chatting.presentation.data.dto.ChatDto;
import com.ds.ds.domain.chatting.presentation.data.dto.ChatMessageDto;
import com.ds.ds.domain.chatting.presentation.data.request.ChatRequest;
import com.ds.ds.domain.chatting.presentation.data.response.ChatResponse;
import com.ds.ds.domain.chatting.service.CreateChatRoomService;
import com.ds.ds.domain.chatting.service.SendMessageService;
import com.ds.ds.domain.chatting.util.ChatConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {
    private final SendMessageService sendMessageService;
    private final ChatConverter chatConverter;
    private final CreateChatRoomService createChatRoomService;
    private final ChatDto chatDto;

    @MessageMapping("/send")
    @SendTo("/sub/chat/room/{roomId}")
    public ResponseEntity<ChatResponse> sendMessage(@DestinationVariable String roomId, @Payload ChatRequest chatRequest) {
        ChatMessageDto chatMessageDto = sendMessageService.sendMessage(roomId, chatRequest);
        ChatResponse chatResponse = chatConverter.toResponse(chatMessageDto);
        return ResponseEntity.ok(chatResponse);
    }

    @PostMapping
    public ResponseEntity<Void> createChatRoom(){
        createChatRoomService.createChatRoom(chatDto);
        return new  ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/history/{roomId}")
    @ResponseBody
    public ResponseEntity<List<ChatMessageDto>> getChatHistory(@PathVariable String roomId, @RequestParam("startIndex") Long startIndex, @RequestParam("endIndex") Long endIndex) {
        List<ChatMessageDto> chatHistory = sendMessageService.getChatHistory(roomId, startIndex, endIndex);
        return ResponseEntity.ok(chatHistory);
        }
    }

