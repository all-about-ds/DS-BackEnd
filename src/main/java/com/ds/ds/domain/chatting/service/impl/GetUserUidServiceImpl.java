package com.ds.ds.domain.chatting.service.impl;

import com.ds.ds.domain.chatting.presentation.data.dto.GetUserUidDto;
import com.ds.ds.domain.chatting.service.GetUserUidService;
import com.ds.ds.domain.chatting.util.ChatConverter;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserUidServiceImpl implements GetUserUidService {
    private final UserUtil userUtil;
    private final ChatConverter chatConverter;
    @Override
    public GetUserUidDto get() {
        User currentUser = userUtil.currentUser();
        return chatConverter.toDto(currentUser);
    }
}
