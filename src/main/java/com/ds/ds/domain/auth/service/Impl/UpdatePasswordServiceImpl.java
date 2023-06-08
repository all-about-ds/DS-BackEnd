package com.ds.ds.domain.auth.service.Impl;

import com.ds.ds.domain.auth.presentation.data.dto.UpdatePasswordDto;
import com.ds.ds.domain.auth.service.UpdatePasswordService;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UpdatePasswordServiceImpl implements UpdatePasswordService {
    private final PasswordEncoder passwordEncoder;
    private final UserUtil userUtil;

    @Override
    @Transactional
    public void update(UpdatePasswordDto updatePasswordDto) {
        String encodingPassword = passwordEncoder.encode(updatePasswordDto.getPassword());
        User user = userUtil.findUserByEmail(updatePasswordDto.getEmail());
        user.updatePassword(encodingPassword);
    }
}
