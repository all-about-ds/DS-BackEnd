package com.ds.ds.domain.user.service.impl;

import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.domain.repository.UserRepository;
import com.ds.ds.domain.user.presentation.data.dto.UpdateUserProfileImgDto;
import com.ds.ds.domain.user.service.UpdateUserProfileService;
import com.ds.ds.domain.user.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateUserProfileServiceImpl implements UpdateUserProfileService {
    private final UserUtil userUtil;
    private final UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserProfileImg(UpdateUserProfileImgDto dto) {
        User user = userUtil.currentUser();

        user.updateProfileImg(dto.getUpdateUserProfileImg());
        userRepository.save(user);
    }
}
