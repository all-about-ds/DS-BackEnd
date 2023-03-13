package com.ds.ds.domain.chatting.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/chat")
public class RoomController {

    @GetMapping("/rooms")
    public String getRooms(){
        return "chat/rooms";
    }

    @GetMapping(value = "/room")
    public String getRoom(Long chatRoomId, String nickname, Model model){

        model.addAttribute("chatRoomId", chatRoomId);
        model.addAttribute("nickname", nickname);

        return "chat/room";
    }
}