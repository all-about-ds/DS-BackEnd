package com.ds.ds.domain.user.service.impl;

import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.presentation.data.dto.HeaderDto;
import com.ds.ds.domain.user.service.GetHeaderService;
import com.ds.ds.domain.user.util.UserConverter;
import com.ds.ds.domain.user.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetHeaderServiceImpl implements GetHeaderService {
    private final UserUtil userUtil;
    private final UserConverter userConverter;
    @Override
    public HeaderDto getHeader() {
        User user = userUtil.currentUser();
        return userConverter.toDto(user);
    }
}
