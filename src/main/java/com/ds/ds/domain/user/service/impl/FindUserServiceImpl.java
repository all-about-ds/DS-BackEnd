package com.ds.ds.domain.user.service.impl;

import com.ds.ds.domain.user.presentation.data.dto.UserDto;
import com.ds.ds.domain.user.service.FindUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindUserServiceImpl implements FindUserService {
    @Override
    public UserDto findUser() {
        return null;
    }
}
