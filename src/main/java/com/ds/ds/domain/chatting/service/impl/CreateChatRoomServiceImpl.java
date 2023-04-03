package com.ds.ds.domain.chatting.service.impl;

import com.ds.ds.domain.chatting.domain.entity.ChatRoom;
import com.ds.ds.domain.chatting.service.CreateChatRoomService;
import com.ds.ds.domain.member.domain.repository.MemberRepository;
import com.ds.ds.domain.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateChatRoomServiceImpl implements CreateChatRoomService {
    private final MemberRepository memberRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ChatRoom createChatRoom(User sender, String other) {
        User otherUser = memberRepository.findMemberByUser(other);
    }
}
