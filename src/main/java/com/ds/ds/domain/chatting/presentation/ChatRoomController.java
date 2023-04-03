package com.ds.ds.domain.chatting.presentation;

import com.ds.ds.domain.chatting.domain.entity.ChatRoom;
import com.ds.ds.domain.chatting.domain.repository.ChatRoomRepository;
import com.ds.ds.domain.chatting.presentation.data.dto.LoginInfo;
import com.ds.ds.domain.chatting.service.CreateChatRoomService;
import com.ds.ds.global.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
public class ChatRoomController {
    private final ChatRoomRepository chatRoomRepository;
    private final CreateChatRoomService createChatRoomService;
    private final JwtProvider jwtProvider;
    @GetMapping("/user")
    @ResponseBody
    public LoginInfo getUserInfo() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        return LoginInfo.builder().name(name).token(jwtProvider.generateToken(name)).build();
    }

    // 채팅방 생성
    @PostMapping("/room")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam String name) {

        return chatRoom;
    }

}
