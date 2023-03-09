package com.ds.ds.domain.user.service.impl;

import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.domain.repository.UserRepository;
import com.ds.ds.domain.user.presentation.data.dto.UpdateUserNameDto;
import com.ds.ds.domain.user.service.UpdateUserNameService;
import com.ds.ds.domain.user.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateUserNameServiceImpl implements UpdateUserNameService {
    private final UserUtil userUtil;
    private final UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserName(UpdateUserNameDto dto) {
        User user = userUtil.currentUser();

        user.updateName(dto.getName());
        userRepository.save(user);
    }
}
