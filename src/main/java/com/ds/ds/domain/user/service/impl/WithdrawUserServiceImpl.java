package com.ds.ds.domain.user.service.impl;

import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.domain.repository.UserRepository;
import com.ds.ds.domain.user.service.WithdrawUserService;
import com.ds.ds.domain.user.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class WithdrawUserServiceImpl implements WithdrawUserService {
    private final UserRepository userRepository;
    private final UserUtil userUtil;

    @Override
    public void withdrawUser() {
        User user = userUtil.currentUser();

        userRepository.delete(user);
    }
}
