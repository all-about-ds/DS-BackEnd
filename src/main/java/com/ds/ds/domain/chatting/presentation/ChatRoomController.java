package com.ds.ds.domain.chatting.presentation;

import com.ds.ds.domain.chatting.domain.repository.ChatRoomRepository;
import com.ds.ds.domain.chatting.presentation.data.dto.LoginInfo;
import com.ds.ds.domain.user.util.Impl.UserUtilImpl;
import com.ds.ds.global.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
public class ChatRoomController {
    private final ChatRoomRepository chatRoomRepository;
    private final JwtProvider jwtProvider;
    private final UserUtilImpl userUtil;

    @GetMapping("/user")
    @ResponseBody
    public LoginInfo getUserInfo() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        return LoginInfo.builder().name(name).token(jwtProvider.ge).build();
    }

}
