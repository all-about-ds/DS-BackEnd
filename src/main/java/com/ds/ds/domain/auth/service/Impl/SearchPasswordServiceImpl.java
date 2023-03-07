package com.ds.ds.domain.auth.service.Impl;

import com.ds.ds.domain.auth.presentation.data.dto.SearchPasswordDto;
import com.ds.ds.domain.auth.service.SearchPasswordService;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.exception.PasswordNotMatchException;
import com.ds.ds.domain.user.util.UserUtil;
import com.ds.ds.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class SearchPasswordServiceImpl implements SearchPasswordService {
    private final PasswordEncoder passwordEncoder;
    private final UserUtil userUtil;

    @Override
    @Transactional
    public void search(SearchPasswordDto searchPasswordDto) {
        if(!searchPasswordDto.getPassword().equals(searchPasswordDto.getCheckPassword())){
            throw new PasswordNotMatchException(ErrorCode.PASSWORD_NOT_MATCH);
        }

        String encodingPassword = passwordEncoder.encode(searchPasswordDto.getPassword());
        User user = userUtil.findUserByEmail(searchPasswordDto.getEmail());
        user.updatePassword(encodingPassword);
    }
}
