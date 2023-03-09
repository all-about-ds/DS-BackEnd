package com.ds.ds.domain.chatting.presentation;

import com.ds.ds.domain.chatting.domain.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "chat")
@Slf4j
public class RoomController {
    private final ChatRoomRepository chatRoomRepository;
    //채팅방 목록 조회
    @GetMapping(value = "/rooms")
    public ModelAndView rooms(){
        log.info("# All chat Rooms");
        ModelAndView mv = new ModelAndView("chat/rooms");

        mv.addObject("list",chatRoomRepository.findAllRooms());
        return mv;
    }
    //채팅방 개설
    @PostMapping(value = "/room")
    public String create(@RequestParam String name, RedirectAttributes rttr) {
        log.info("# create chat room , name"+ name);
        rttr.addFlashAttribute("roomName",chatRoomRepository.createChatRoomDto(name));
        return "redirect:/chat/rooms";
    }
    //채팅방 조회
    @GetMapping("/room")
    public void getRoom(String roomdId, Model model) {
        log.info("# get Chat Room, roomId : " + roomdId);

        model.addAttribute("room",chatRoomRepository.findRoomById(roomdId));
    }
    //채팅에 참여한 유저 닉네임 중복 확인
    @GetMapping("/chat/duplicateName")
    @ResponseBody
    public String isDuplicateName(@RequestParam("roomId") String roomId, @RequestParam("username")String username) {
        String userName = chatRoomRepository.isDuplicateName(roomId,username);
        log.info("동작확인 {}",userName);

        return userName;
    }
}
