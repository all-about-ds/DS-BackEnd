package com.ds.ds.domain.chatting.presentation;

import com.ds.ds.domain.chatting.domain.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "chat")
@Slf4j
public class RoomController {
    private final ChatRoomRepository chatRoomRepository
    //채팅방 목록 조회
    @GetMapping(value = "/rooms")
    public ModelAndView rooms(){
        log.info("# All chat Rooms");
        ModelAndView mv = new ModelAndView("chat/rooms");

        mv.addObject("list",chatRoomRepository.findAllRooms());
        return mv;

    }
}
